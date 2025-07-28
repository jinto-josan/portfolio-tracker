package com.jmj.portfolio.tracker.application.ports.out;

import com.jmj.portfolio.tracker.application.domain.models.User;

public interface UserPort {
  public void saveUser(User user);
}
