package com.jmj.portfolio.tracker.application.domain.models;

public enum PaymentFrequency {
  YEARLY(1),
  HALF_YEARLY(2),
  QUARTERLY(4),
  MONTHLY(12);

  private final int value;
  PaymentFrequency(int value){
    this.value=value;
  }

  public int getFrequencyMultiplier(){
    return value;
  }
}
