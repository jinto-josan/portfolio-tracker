package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.AssetEntity;
import com.jmj.portfolio.tracker.adapters.out.persistance.entities.FixedIncomeEntity;
import com.jmj.portfolio.tracker.adapters.out.persistance.entities.StockEntity;
import com.jmj.portfolio.tracker.application.domain.models.Asset;
import com.jmj.portfolio.tracker.application.domain.models.FixedIncome;
import com.jmj.portfolio.tracker.application.domain.models.Stock;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses={FixedIncomeEntityMapper.class, StockEntityMapper.class})
public abstract class AssetEntityMapper {
  @Autowired
  protected FixedIncomeEntityMapper fixedIncomeEntityMapper;

  @Autowired
  protected StockEntityMapper stockEntityMapper;

  public Asset toDomain(AssetEntity entity) {
    if (entity instanceof FixedIncomeEntity) {
      return fixedIncomeEntityMapper.toDomain((FixedIncomeEntity) entity);
    } else if (entity instanceof StockEntity) {
      return stockEntityMapper.toDomain((StockEntity) entity);
    }
    throw new IllegalArgumentException("Unknown HoldingEntity subclass: " + entity.getClass());
  }

  public AssetEntity fromDomain(Asset domain) {
    if (domain instanceof FixedIncome) {
      return fixedIncomeEntityMapper.fromDomain((FixedIncome) domain);
    } else if (domain instanceof Stock) {
      return stockEntityMapper.fromDomain((Stock) domain);
    }
    throw new IllegalArgumentException("Unknown Holding subclass: " + domain.getClass());
  }
}
