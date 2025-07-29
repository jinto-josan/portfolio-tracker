package com.jmj.portfolio.tracker.adapters.out.persistance.repository;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity,Long> {

  List<PortfolioEntity> findByUser_NameAndUser_Email(String name, String email);
  Optional<PortfolioEntity> findByNameAndUser_NameAndUser_Email(String name, String username, String email);

}
