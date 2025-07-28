package com.jmj.portfolio.tracker.common.error;

public abstract class BaseErrorCode implements ErrorCode {
  private final String code;
  private final String message;
  protected BaseErrorCode(String code, String message){
    this.code=code;
    this.message=message;
  }

  @Override
  public String code(){
    return code;
  }
  @Override
  public String message(){
    return  message;
  }
}
