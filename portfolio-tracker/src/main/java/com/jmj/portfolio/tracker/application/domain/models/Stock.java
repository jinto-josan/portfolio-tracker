package com.jmj.portfolio.tracker.application.domain.models;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Stock extends Asset{
  private final double value;
  private final String stockExchange;
  public Stock(String name, Instant yieldFetchedAt,
               String stockExchange,double value) {
    super(name, yieldFetchedAt, AssetType.STOCK);
    this.value=value;
    this.stockExchange=stockExchange;
  }

  @Override
  public double getMultiplier() {
    return value;
  }

  @Override
  protected void validAsset() {
    if(this.stockExchange == null || this.stockExchange.isBlank()) {
      throw new BusinessException(BusinessErrorCode.NULL_STOCK_EXCHANGE);
    }
    if(this.value <= 0) {
      throw new BusinessException(BusinessErrorCode.INVALID_PRICE);
    }
  }
}
