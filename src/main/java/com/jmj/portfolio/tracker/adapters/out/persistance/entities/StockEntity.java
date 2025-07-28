package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StockEntity extends AssetEntity {
  private  double value;
  private  String stockExchange;
}
