package com.jmj.portfolio.tracker.application.ports.in;

import com.jmj.portfolio.tracker.application.domain.models.Holding;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;

import java.util.Optional;

public interface PortfolioUseCase {

  public void addPortfolio(Portfolio portfolio);
  Optional<Portfolio> getPortfolioDetails(Portfolio portfolio);

}
