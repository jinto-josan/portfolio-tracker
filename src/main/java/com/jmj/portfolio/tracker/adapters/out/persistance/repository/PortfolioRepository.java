package com.jmj.portfolio.tracker.adapters.out.persistance.repository;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity,Long> {
}
