package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.InterestType;
import com.jmj.portfolio.tracker.application.domain.models.PaymentFrequency;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.time.Period;

@Entity
public class FixedIncomeEntity {
  private  double rate;
  private  InterestType interestType;
  private  PaymentFrequency paymentFrequency;
  private  Period period;
}
