package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.Asset;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.Instant;

public class HoldingEntity extends AuditableEntity {
  private Asset asset;
  private double units;
  private Instant txnDoneAt;
  @ManyToOne
  @JoinColumn(name = "portfolio_id")
  private Portfolio portfolio;
}
