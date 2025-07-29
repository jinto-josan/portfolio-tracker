package com.jmj.portfolio.tracker.application.domain.service;

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
    getUser(user);
    userPort.saveUser(user);
  }

  @Override
  public void updateUserDetails(User user) {
    getUser(user);
    userPort.updateUser(user);
  }

  @Override
  public void deactivateAccount(User user) {
    if(!isUserActive(user)) {
      throw new BusinessException(BusinessErrorCode.INACTIVE_USER);
    }
    user.setActive(false); // Assuming User has an 'active' field
    userPort.updateUser(user);
  }

  @Override
  public User getUser(User user) {
    return userPort.findUser(user)
        .orElseThrow(() -> new BusinessException(BusinessErrorCode.USER_NOT_FOUND));
  }
  @Override
  public boolean isUserActive(User user) {
    return getUser(user).isActive();
  }

}
