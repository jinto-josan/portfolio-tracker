package com.jmj.portfolio.tracker.application.domain.service;

import com.jmj.portfolio.tracker.adapters.out.persistance.UserPersistanceAdapter;
import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.domain.models.User;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import com.jmj.portfolio.tracker.application.ports.in.UserUseCase;
import com.jmj.portfolio.tracker.application.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserUseCaseImpl implements UserUseCase {
  private final UserPort userPort;

  @Override
  public void registerUser(User user) {
    if (userPort.findUser(user).isPresent()) {
      throw new BusinessException(BusinessErrorCode.USER_ALREADY_EXISTS);
    }
    userPort.saveUser(user);
  }

  @Override
  public void updateUserDetails(User user) {
    userPort.findUser(user)
        .orElseThrow(() -> new BusinessException(BusinessErrorCode.USER_NOT_FOUND));
    userPort.updateUser(user);
  }

  @Override
  public void deactivateAccount(User user) {
    userPort.findUser(user)
        .orElseThrow(() -> new BusinessException(BusinessErrorCode.USER_NOT_FOUND));
    user.setActive(false); // Assuming User has an 'active' field
    userPort.updateUser(user);

  }

}
