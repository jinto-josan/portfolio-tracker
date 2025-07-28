package com.jmj.portfolio.tracker.adapters.out.persistance;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.UserEntity;
import com.jmj.portfolio.tracker.adapters.out.persistance.mappers.UserEntityMapper;
import com.jmj.portfolio.tracker.adapters.out.persistance.repository.UserRepository;
import com.jmj.portfolio.tracker.application.domain.models.User;
import com.jmj.portfolio.tracker.application.ports.out.UserPort;

import java.util.Optional;

public class UserPersistanceAdapter implements UserPort {

  private UserRepository userRepository;
  private UserEntityMapper userEntityMapper;

  @Override
  public void saveUser(User user) {
    userRepository.save(userEntityMapper.fromDomain(user));
  }
  public Optional<User> findUser(User user){
    return  Optional.of(user);
//    return userRepository.findOne((UserEntity)userEntityMapper.fromDomain(user))
//        .map(ue->userEntityMapper.toDomain(ue));
  }
}
