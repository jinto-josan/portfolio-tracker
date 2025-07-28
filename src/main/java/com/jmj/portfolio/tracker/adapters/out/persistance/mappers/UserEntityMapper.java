package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.UserEntity;
import com.jmj.portfolio.tracker.application.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends GenericEntityMapper<User,UserEntity> {
}
