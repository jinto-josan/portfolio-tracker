package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.Asset;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table
(
    name = "holdings",
    schema = "public"
)
public class HoldingEntity extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  @JoinColumn(name= "asset_id")
  private AssetEntity asset;
  private double units;
  private Instant txnDoneAt;
  @ManyToOne
  @JoinColumn(name = "portfolio_id")
  private PortfolioEntity portfolio;
}
