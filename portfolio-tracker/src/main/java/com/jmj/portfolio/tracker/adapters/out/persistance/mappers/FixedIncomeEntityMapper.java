package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.FixedIncomeEntity;
import com.jmj.portfolio.tracker.application.domain.models.FixedIncome;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={AssetEntityMapper.class})
public interface FixedIncomeEntityMapper extends GenericEntityMapper<FixedIncome, FixedIncomeEntity> {
}
