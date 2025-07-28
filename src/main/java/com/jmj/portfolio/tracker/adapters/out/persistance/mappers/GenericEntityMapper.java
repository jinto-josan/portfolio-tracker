package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenericEntityMapper<D,E> {
  D toDomain(E entity);
  E fromDomain(D domain);
}
