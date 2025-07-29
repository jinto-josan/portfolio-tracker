package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.AssetType;
import com.jmj.portfolio.tracker.application.domain.models.FixedIncome;
import com.jmj.portfolio.tracker.application.domain.models.InterestType;
import com.jmj.portfolio.tracker.application.domain.models.PaymentFrequency;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.Period;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FixedIncomeEntity extends AssetEntity {
  private  double rate;
  private  InterestType interestType;
  private  PaymentFrequency paymentFrequency;
  private  Period period;

}
