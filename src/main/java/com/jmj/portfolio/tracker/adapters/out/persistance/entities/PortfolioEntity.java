package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import com.jmj.portfolio.tracker.application.domain.models.Holding;
import com.jmj.portfolio.tracker.application.domain.models.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "portfolios",
    schema = "public",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name","user_id"})
)
public class PortfolioEntity extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<HoldingEntity> holdings=new ArrayList<>();
}
