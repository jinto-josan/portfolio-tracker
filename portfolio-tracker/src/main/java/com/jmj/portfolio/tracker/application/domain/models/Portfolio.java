package com.jmj.portfolio.tracker.application.domain.models;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
public class Portfolio {

  @EqualsAndHashCode.Include
  private String name;
  private List<Holding> holdings;
  @EqualsAndHashCode.Include
  private User user;

  @Generated("Mapstruct")
  public Portfolio(){
    holdings=new LinkedList<>();
  }

  public Portfolio(String name, User user) {
    this.name = name;
    this.user = user;
    this.holdings = new LinkedList<>();
    validatePortfolio();

  }

  public double getInvestedValue(){
    return holdings.parallelStream().reduce(0d,
        (partialResult, holding)->
            partialResult+ holding.getCurrentValue(),
        Double::sum);
  }

  public void addHolding(Holding holding) {
    if (holding == null) {
      throw new BusinessException(BusinessErrorCode.NULL_HOLDING);
    }
    holdings.add(holding);
  }


  public void validatePortfolio() {
    if(this.user == null) {
      throw new BusinessException(BusinessErrorCode.INVALID_USER);
    }
    this.user.validateUser();
    if (this.name == null || this.name.isBlank()) {
      throw  new BusinessException(BusinessErrorCode.INVALID_PORTFOLIO);
    }
  }

}
