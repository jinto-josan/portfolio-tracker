package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.HoldingEntity;
import com.jmj.portfolio.tracker.application.domain.models.Holding;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AssetEntityMapper.class})
public interface HoldingEntityMapper extends GenericEntityMapper<Holding, HoldingEntity> {
}
