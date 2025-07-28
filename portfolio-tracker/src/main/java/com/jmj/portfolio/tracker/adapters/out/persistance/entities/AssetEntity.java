package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.AssetType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AssetEntity extends AuditableEntity {
  private  String name;
  private double yieldFetchedAt;
}
