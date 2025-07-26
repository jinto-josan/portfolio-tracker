package com.jmj.portfolio.tracker.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public abstract class Asset {
  private final String name;
  private final double yieldFetchedAt;
  private final AssetType assetType;

  public abstract double  getMultiplier();
}
