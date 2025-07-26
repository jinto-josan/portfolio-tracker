package com.jmj.portfolio.tracker.application.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Stock extends Asset{
  private final double value;
  private final String stockExchange;
  public Stock(String name, double yieldFetchedAt,
               String stockExchange,double value) {
    super(name, yieldFetchedAt, AssetType.STOCK);
    this.value=value;
    this.stockExchange=stockExchange;
  }

  @Override
  public double getMultiplier() {
    return value;
  }
}
