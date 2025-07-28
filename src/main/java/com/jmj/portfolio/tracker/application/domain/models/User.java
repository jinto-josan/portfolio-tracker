package com.jmj.portfolio.tracker.application.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
  @EqualsAndHashCode.Include
  private String name;
  @EqualsAndHashCode.Include
  private String email;
}
