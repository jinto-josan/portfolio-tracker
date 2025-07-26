package com.jmj.portfolio.tracker.application.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Data
public class Portfolio {

  @EqualsAndHashCode.Include
  private String name;
  private List<Holding> holdings;
  private Instant createdAt;
  @EqualsAndHashCode.Include
  private User user;

  public Portfolio(){
    holdings=new LinkedList<>();
  }
  public double getInvestedValue(){
    return holdings.parallelStream().reduce(0d,
        (partialResult, holding)->
            partialResult+ holding.getCurrentValue(),
        Double::sum);
  }

}
