package com.jmj.portfolio.tracker.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Holding {
  private Asset asset;
  private Portfolio portfolio;
  //This is the field where holding was sold or bought and is editable
  private Instant txnDoneAt;
  private double units;
  public  double getCurrentValue(){
    return asset.getMultiplier()*units;
  }
}
