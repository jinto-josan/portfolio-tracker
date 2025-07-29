package com.jmj.portfolio.tracker.adapters.out.persistance;

import com.jmj.portfolio.tracker.adapters.out.persistance.mappers.PortfolioEntityMapper;
import com.jmj.portfolio.tracker.adapters.out.persistance.repository.PortfolioRepository;
import com.jmj.portfolio.tracker.adapters.out.persistance.repository.UserRepository;
import com.jmj.portfolio.tracker.application.domain.models.Holding;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import com.jmj.portfolio.tracker.application.domain.models.User;
import com.jmj.portfolio.tracker.application.ports.out.PortfolioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PortfolioPersistanceAdapter implements PortfolioPort {

  private final PortfolioRepository portfolioRepository;
  private final UserRepository userRepository;
  private final PortfolioEntityMapper portfolioEntityMapper;

  @Override
  public void add(Portfolio portfolio) {
    userRepository.findByNameAndEmail(portfolio.getUser().getName(), portfolio.getUser().getEmail())
        .ifPresent(
            userEntity -> {
              var entity=portfolioEntityMapper.fromDomain(portfolio);
              entity.setUser(userEntity);
              portfolioRepository.save(entity);
            }
        );

  }

  @Override
  public void update(Portfolio portfolio) {

  }

  @Override
  public List<Portfolio> findPortfolioByUser(User user) {
    return null;
  }

  @Override
  public Optional<Portfolio> findPortfolioByName(User user, String portfolioName) {
    return Optional.empty();
  }

  @Override
  public void deletePortfolio(Portfolio portfolio) {

  }

  @Override
  public void addHolding(Portfolio portfolio, Holding holding, boolean BUY_SELL_FLAG) {

  }

  @Override
  public void updateHolding(Portfolio portfolio, Holding holding) {

  }
}
