package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "stocks",
    schema = "public"
)
public class StockEntity extends AssetEntity {
  private  double value;
  private  String stockExchange;
}
