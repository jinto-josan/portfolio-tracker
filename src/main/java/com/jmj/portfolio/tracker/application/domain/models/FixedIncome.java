package com.jmj.portfolio.tracker.application.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Duration;
import java.time.Period;

@Getter
@EqualsAndHashCode(callSuper = true)
public class FixedIncome extends Asset {
  private final double rate;
  private final InterestType interestType;
  private final PaymentFrequency paymentFrequency;
  private final Period period;

  public FixedIncome(String name, double yieldFetchedAt,
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

}
