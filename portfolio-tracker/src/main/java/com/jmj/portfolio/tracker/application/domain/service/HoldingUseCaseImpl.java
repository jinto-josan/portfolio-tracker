package com.jmj.portfolio.tracker.application.domain.service;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.domain.models.Holding;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import com.jmj.portfolio.tracker.application.ports.in.HoldingUseCase;
import com.jmj.portfolio.tracker.application.ports.out.PortfolioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class HoldingUseCaseImpl implements HoldingUseCase {

  private final PortfolioPort portfolioPort;


  @Override
  public void addHolding( Holding holding) {

    portfolioPort.findPortfolioByName(holding.getPortfolio().getUser(),
            holding.getPortfolio().getName())
        .ifPresentOrElse(portfolio ->
              portfolioPort.addHolding(List.of(holding)),
            () -> {throw new BusinessException(BusinessErrorCode.PORTFOLIO_NOT_FOUND);}
        );
  }

  @Override
  public void sellHolding(Holding holding) {
    portfolioPort.findPortfolioByName(holding.getPortfolio().getUser(),
            holding.getPortfolio().getName())
        .ifPresentOrElse(
            existingPortfolio -> {
              removeHoldingInFIFO(holding, existingPortfolio);
            },
            () -> {throw new BusinessException(BusinessErrorCode.PORTFOLIO_NOT_FOUND);}
        );

  }

  private void removeHoldingInFIFO(Holding holding, Portfolio portfolio) {
    if (holding == null) {
      throw new BusinessException(BusinessErrorCode.NULL_HOLDING);
    }
    var holdingsToBeRemoved = new LinkedList<Holding>();
    double quantity=holding.getUnits();
    var sortedHoldings= portfolio.getHoldings().stream()
        .filter(hold->
            holding.getAsset().getName().equalsIgnoreCase(hold.getAsset().getName())
            && holding.getAsset().getAssetType().equals(hold.getAsset().getAssetType())

        )
        .sorted().toList();

    while (quantity > 0 && !sortedHoldings.isEmpty()) {
      Holding hold= sortedHoldings.get(0);
      if (hold.getUnits() <= quantity) {
        quantity -= hold.getUnits();
        sortedHoldings.remove(0);
        holdingsToBeRemoved.add(hold);
      } else {
        hold.setUnits(hold.getUnits() - quantity);
        sortedHoldings.remove(0);
        sortedHoldings.add(0, hold);
        quantity = 0.0;
        portfolioPort.updateHolding(hold);
      }
    }
    if (quantity > 0) {
      throw new BusinessException(BusinessErrorCode.INSUFFICIENT_UNITS);
    }
    portfolioPort.deleteHolding(holdingsToBeRemoved);
  }

  @Override
  public void updateHolding(Holding holding) {

  }
}
