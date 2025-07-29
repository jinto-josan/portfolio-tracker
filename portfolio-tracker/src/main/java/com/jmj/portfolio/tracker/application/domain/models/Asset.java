package com.jmj.portfolio.tracker.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
public abstract class Asset {
  private final String name;
  private final Instant yieldFetchedAt;
  private final AssetType assetType;

  public abstract double  getMultiplier();
  protected abstract void validAsset();
  public  void validateAsset(){
    if (this.name == null || this.name.isBlank()) {
      throw new IllegalArgumentException("Asset name cannot be null or blank");
    }
    if (this.yieldFetchedAt == null) {
      throw new IllegalArgumentException("Yield fetched at cannot be negative");
    }
    validAsset();
  }
}
