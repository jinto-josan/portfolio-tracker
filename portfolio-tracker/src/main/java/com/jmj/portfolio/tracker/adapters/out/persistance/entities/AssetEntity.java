package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.AssetType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AssetEntity extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  @NonNull
  private  String name;
  @NonNull
  private Instant yieldFetchedAt;
  @Enumerated
  @NonNull
  private AssetType assetType;


}
