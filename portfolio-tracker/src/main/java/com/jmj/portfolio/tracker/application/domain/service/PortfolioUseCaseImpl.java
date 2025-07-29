package com.jmj.portfolio.tracker.application.domain.service;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import com.jmj.portfolio.tracker.application.ports.in.PortfolioUseCase;
import com.jmj.portfolio.tracker.application.ports.out.PortfolioPort;
import com.jmj.portfolio.tracker.application.ports.out.UserPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PortfolioUseCaseImpl implements PortfolioUseCase {
    private final PortfolioPort portfolioPort;
    private final UserUseCaseImpl userUseCase;

  @Override
  public void addPortfolio(Portfolio portfolio) {
    if(getPortfolioDetails(portfolio).isEmpty())
      portfolioPort.add(portfolio);
    else
      throw new BusinessException(BusinessErrorCode.PORTFOLIO_ALREADY_EXISTS);
  }

  @Override
  public Optional<Portfolio> getPortfolioDetails(Portfolio portfolio) {
    if(userUseCase.isUserActive(portfolio.getUser()))
      return portfolioPort.findPortfolioByName(portfolio.getUser(), portfolio.getName());
    throw new BusinessException(BusinessErrorCode.INACTIVE_USER);

  }
}
