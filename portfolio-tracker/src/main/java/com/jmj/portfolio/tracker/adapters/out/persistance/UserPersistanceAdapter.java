package com.jmj.portfolio.tracker.adapters.out.persistance;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.UserEntity;
import com.jmj.portfolio.tracker.adapters.out.persistance.mappers.UserEntityMapper;
import com.jmj.portfolio.tracker.adapters.out.persistance.repository.UserRepository;
import com.jmj.portfolio.tracker.application.domain.models.User;
import com.jmj.portfolio.tracker.application.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserPersistanceAdapter implements UserPort {

  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  @Override
  public void saveUser(User user) {
    userRepository.save(userEntityMapper.fromDomain(user));
  }
  public Optional<User> findUser(User user){
    return findUserEntity(user)
        .map(userEntityMapper::toDomain);
  }
  public void updateUser(User user) {
    findUserEntity(user)
        .map(userEntity -> {
          userEntity.setActive(user.isActive());
          return userEntity;
        })
        .ifPresent(userRepository::save);
  }

  private Optional<UserEntity> findUserEntity(User user) {
    return userRepository.findOne(
        Example.of(new UserEntity(user.getName(), user.getEmail()),
            ExampleMatcher.matching()
                .withIgnorePaths("id", "isActive", "createdAt", "updatedAt")
        )
    );
  }
}
