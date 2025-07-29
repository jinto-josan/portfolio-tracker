package com.jmj.portfolio.tracker.adapters.out.persistance.repository;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.HoldingEntity;
import com.jmj.portfolio.tracker.adapters.out.persistance.entities.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.time.Instant;
import java.util.Optional;

public interface HoldingRepository extends JpaRepository<HoldingEntity, Long> {

    Optional<HoldingEntity> findByPortfolioAndHolding_txnDoneAt(PortfolioEntity portfolioEntity, Instant txnDoneAt);
}
