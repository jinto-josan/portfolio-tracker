package com.jmj.portfolio.tracker.application.domain.models;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
public class Holding {
  private Asset asset;
  private Portfolio portfolio;
  //This is the field where holding was sold or bought and is editable
  private Instant txnDoneAt;
  private double units;
  public  double getCurrentValue(){
    return asset.getMultiplier()*units;
  }
  public Holding(Asset asset, Portfolio portfolio, Instant txnDoneAt, double units) {
    this.asset = asset;
    this.portfolio = portfolio;
    this.txnDoneAt = txnDoneAt;
    this.units = units;
    validateHolding();
  }
  public void validateHolding() {
    if (this.asset == null) {
      throw new BusinessException(BusinessErrorCode.INVALID_ASSET);
    }
    this.asset.validateAsset();
    if (this.portfolio == null) {
      throw new BusinessException(BusinessErrorCode.NULL_PORTFOLIO);
    }
    this.portfolio.validatePortfolio();
    if (this.txnDoneAt == null) {
      throw new BusinessException(BusinessErrorCode.NULL_TXN_DATE);
    }
    if (this.units <= 0) {
      throw new BusinessException(BusinessErrorCode.INVALID_QUANTITY);
    }
  }
}
