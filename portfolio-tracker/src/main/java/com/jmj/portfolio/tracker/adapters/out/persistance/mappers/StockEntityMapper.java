package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.StockEntity;
import com.jmj.portfolio.tracker.application.domain.models.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockEntityMapper extends GenericEntityMapper<Stock, StockEntity> {
}
