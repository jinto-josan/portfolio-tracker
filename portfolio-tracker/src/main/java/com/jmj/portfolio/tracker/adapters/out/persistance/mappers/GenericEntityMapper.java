package com.jmj.portfolio.tracker.adapters.out.persistance.mappers;

import org.mapstruct.Mapper;

import java.util.List;


public interface GenericEntityMapper<D,E> {
  D toDomain(E entity);
  E fromDomain(D domain);

  List<D> toDomainList(List<E> entities);
  List<E> fromDomainList(List<D> domains);
}
