package com.jmj.portfolio.tracker.application.ports.out;

import com.jmj.portfolio.tracker.application.domain.models.Holding;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import com.jmj.portfolio.tracker.application.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface PortfolioPort {

  void add(Portfolio portfolio);

  void update(Portfolio portfolio);

  List<Portfolio> findPortfolioByUser(User user);

  Optional<Portfolio> findPortfolioByName(User user, String portfolioName);

  void deletePortfolio(Portfolio portfolio);

  void addHolding(Portfolio portfolio, Holding holding, boolean BUY_SELL_FLAG);
  void updateHolding(Portfolio portfolio, Holding holding);
}
