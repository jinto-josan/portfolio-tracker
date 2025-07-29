package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.PortfolioEntity;
import com.jmj.portfolio.tracker.adapters.out.persistance.entities.UserEntity;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import com.jmj.portfolio.tracker.application.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {HoldingEntityMapper.class})
public interface PortfolioEntityMapper extends GenericEntityMapper<Portfolio,PortfolioEntity> {
}
