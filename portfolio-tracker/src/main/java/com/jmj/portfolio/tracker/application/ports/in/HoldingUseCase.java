package com.jmj.portfolio.tracker.application.ports.in;

import com.jmj.portfolio.tracker.application.domain.models.Holding;
import com.jmj.portfolio.tracker.application.domain.models.Portfolio;
import com.jmj.portfolio.tracker.application.domain.models.User;

public interface HoldingUseCase {

  public void addHolding(Portfolio portfolio, Holding holding);
  public void sellHolding(Holding holding);
  public void updateHolding(Holding holding);

}
