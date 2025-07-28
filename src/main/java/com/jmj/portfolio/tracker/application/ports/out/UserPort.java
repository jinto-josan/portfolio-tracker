package com.jmj.portfolio.tracker.application.ports.out;

import com.jmj.portfolio.tracker.application.domain.models.User;

public interface UserPort {
  public void registerUser(User user);
  public void updateUserDetails(User user);
  public void deactivateAccount(User user);
}
