package com.jmj.portfolio.tracker.adapters.out.persistance;

import com.jmj.portfolio.tracker.adapters.out.persistance.mappers.UserEntityMapper;
import com.jmj.portfolio.tracker.adapters.out.persistance.repository.UserRepository;
import com.jmj.portfolio.tracker.application.domain.models.User;
import com.jmj.portfolio.tracker.application.ports.out.UserPort;

public class UserPersistanceAdapter implements UserPort {

  private UserRepository userRepository;
  private UserEntityMapper userEntityMapper;

  @Override
  public void registerUser(User user) {
    saveUser(user);
  }

  @Override
  public void updateUserDetails(User user) {
    saveUser(user);
  }

  @Override
  public void deactivateAccount(User user) {
    saveUser(user);
  }

  private void saveUser(User user){
    userRepository.save(userEntityMapper.fromDomain(user));
  }
}
