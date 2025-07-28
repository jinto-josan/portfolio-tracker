package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import org.mapstruct.Mapper;


public interface GenericEntityMapper<D,E> {
  D toDomain(E entity);
  E fromDomain(D domain);
}
