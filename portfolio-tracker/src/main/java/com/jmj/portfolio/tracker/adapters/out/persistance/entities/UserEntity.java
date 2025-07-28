package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
    name = "users",
    schema = "public",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name", "email"})
)
public class UserEntity extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PortfolioEntity> portfolioEntities = new ArrayList<>();
}
