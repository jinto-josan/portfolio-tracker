package com.jmj.portfolio.tracker.application.domain.models;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import lombok.*;

import javax.annotation.processing.Generated;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
  @EqualsAndHashCode.Include
  private String name;
  @EqualsAndHashCode.Include
  private String email;
  private boolean isActive;

  @Generated("Mapstruct")
  public  User() {
    this.isActive = true; // Default to active
  }


  public User(String name, String email) {
    this.name = name;
    this.email = email;
    this.isActive = true;
  }
  public User(String name, String email, boolean isActive) {
    this.name = name;
    this.email = email;
    this.isActive = isActive;
  }

  private void validateUSer(User user) {
    if(user == null || user.getEmail().isBlank() || user.getName().isBlank()) {
      throw new BusinessException(BusinessErrorCode.INVALID_USER);
    }
  }

}
