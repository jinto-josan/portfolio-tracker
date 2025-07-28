package com.jmj;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.yaml.snakeyaml.Yaml;

import javax.lang.model.element.Modifier;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ErrorEnumGenerator {
  public static void main(String[] args)  {
    if(args.length<2){
      System.out.println("Usage: java ErrorEnumGenerator <inputYaml> <outputBaseDir>");
      System.exit(1);
    }
    String yamlFile=args[0];
    String outputBaseDir=args[1];

    Yaml yaml=new Yaml();
    try(InputStream in = new FileInputStream(yamlFile)){
      Map<String, Object> data= yaml.load(in);
      List<Map<String, Object>> enums = (List<Map<String,Object>>) data.get("enums");
      for(Map<String, Object> enumDef:enums){
        String enumName=(String) enumDef.get("name");
        String outputPath=(String) enumDef.get("outputPath");
        List<Map<String,String>> errors=(List<Map<String,String>>) enumDef.get("errors");
        String packageName=outputBaseDir.replace('/','.');
        TypeSpec.Builder enumBuilder= TypeSpec.enumBuilder(enumName)
            .addModifiers(Modifier.PUBLIC)
            .addField(String.class,"code", Modifier.PRIVATE, Modifier.FINAL)
            .addField(String.class,"name", Modifier.PRIVATE, Modifier.FINAL)
            .addField(String.class,"message", Modifier.PRIVATE, Modifier.FINAL)
            .addMethod(MethodSpec.constructorBuilder()
                .addParameter(String.class, "code")
                .addParameter(String.class,"name")
                .addParameter(String.class,"message")
                .addStatement("this.code=code")
                .addStatement("this.name=name")
                .addStatement("this.message=message")
                .build());

        for(Map<String,String> error:errors){
          String name=error.get("name");
          String code= error.get("code");
          String message= error.getOrDefault("message", "");
          enumBuilder.addEnumConstant(name,
              TypeSpec.anonymousClassBuilder("$S, $S, $S",code,name,message).build());
        }
        JavaFile javaFile= JavaFile.builder(packageName,enumBuilder.build()).build();
        File outputDir= new File(outputBaseDir,outputPath);
        javaFile.writeTo(outputDir);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}