package com.jmj.portfolio.tracker.adapters.out.persistance;

import com.jmj.portfolio.tracker.adapters.out.persistance.mappers.HoldingEntityMapper;
import com.jmj.portfolio.tracker.adapters.out.persistance.mappers.PortfolioEntityMapper;
import com.jmj.portfolio.tracker.adapters.out.persistance.repository.HoldingRepository;
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
  private final HoldingEntityMapper holdingEntityMapper;
  private final HoldingRepository holdingRepository;

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
    return
        portfolioEntityMapper.toDomainList(
        portfolioRepository.findByUser_NameAndUser_Email(user.getName(), user.getEmail())
        );
  }

  @Override
  public Optional<Portfolio> findPortfolioByName(User user, String portfolioName) {
    return
        portfolioRepository.findByNameAndUser_NameAndUser_Email(
        portfolioName, user.getName(),user.getEmail() )
            .map(portfolioEntityMapper::toDomain);
  }

  @Override
  public void deletePortfolio(Portfolio portfolio) {

  }

  @Override
  public void addHolding(List<Holding> holdingToBeAdded) {
    // Implementation for adding a holding to a portfolio
    holdingRepository.saveAll(
    holdingToBeAdded.stream().map(
        holdingEntityMapper::fromDomain
    ).toList());

  }
  @Override
  public void deleteHolding(List<Holding> holdingsToBeDeleted) {
    // Implementation for deleting a holding from a portfolio
    Portfolio port=holdingsToBeDeleted.get(0).getPortfolio();
    var portfolioEntity=portfolioRepository.findByNameAndUser_NameAndUser_Email(
        port.getName(), port.getUser().getName(), port.getUser().getEmail()
    ).get();
    holdingsToBeDeleted.forEach(
        holding -> {
          holdingRepository.findByPortfolioAndHolding_txnDoneAt(
              portfolioEntity, holding.getTxnDoneAt()
          ).ifPresent(holdingRepository::delete);
        }
    );

  }

  @Override
  public void updateHolding(Holding holdingToBeUpdated) {

  }
}
