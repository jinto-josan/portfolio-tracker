package com.jmj.portfolio.tracker.application.ports.out;

import com.jmj.portfolio.tracker.application.domain.models.User;

import java.util.Optional;

public interface UserPort {
  public void saveUser(User user);
  public Optional<User> findUser(User user);
  public void updateUser(User user);
}
