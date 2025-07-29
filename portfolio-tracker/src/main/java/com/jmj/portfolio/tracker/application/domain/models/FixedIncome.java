package com.jmj.portfolio.tracker.application.domain.models;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

@Getter
@EqualsAndHashCode(callSuper = true)
public class FixedIncome extends Asset {
  private final double rate;
  private final InterestType interestType;
  private final PaymentFrequency paymentFrequency;
  private final Period period;

  public FixedIncome(String name, Instant yieldFetchedAt,
                     double rate, InterestType interestType,
                     PaymentFrequency paymentFrequency, Period period) {
    super(name, yieldFetchedAt, AssetType.FIXED_INCOME);
    this.rate=rate;
    this.interestType=interestType;
    this.paymentFrequency=paymentFrequency;
    this.period = period;
  }
  public double getMultiplier(){
    return switch (interestType){
      case SIMPLE -> 1+rate;
      case COMPOUND -> Math.pow(1+(rate/paymentFrequency.getFrequencyMultiplier()),
       period.getYears()*paymentFrequency.getFrequencyMultiplier());
    };
  }

  @Override
  protected void validAsset() {
    if (rate <= 0 && rate <= 1) {
      throw new BusinessException(BusinessErrorCode.INVALID_FIXED_INCOME_RATE);
    }
    if (interestType == null) {
      throw new BusinessException(BusinessErrorCode.NULL_FIXED_INCOME_TYPE);
    }
    if (paymentFrequency == null) {
      throw new BusinessException(BusinessErrorCode.INVALID_FIXED_INCOME_FREQUENCY);
    }
    if (period == null || period.isNegative() || period.isZero()) {
      throw new BusinessException(BusinessErrorCode.INVALID_FIXED_INCOME_PERIOD);
    }
  }


}
