package com.jmj.portfolio.tracker.adapters.out.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
    name = "users",
    schema = "public",
    uniqueConstraints = @UniqueConstraint(columnNames = {"name", "email"})
)
@RequiredArgsConstructor
@Getter
@Setter
public class UserEntity extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NonNull
  private String name;
  @NonNull
  private String email;
  private boolean isActive;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PortfolioEntity> portfolioEntities = new ArrayList<>();
}
