package com.jmj.portfolio.tracker.application.domain.exception;

import com.jmj.portfolio.tracker.application.exception.BusinessErrorCode;

public class BusinessException extends RuntimeException{
   private final BusinessErrorCode errorCode;

  public BusinessException(BusinessErrorCode errorCode) {
    this.errorCode = errorCode;
  }
  public BusinessErrorCode getErrorCode() {
    return errorCode;
  }
}
