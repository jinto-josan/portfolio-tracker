package com.jmj.portfolio.tracker.adapters.in.controllers;

import com.jmj.portfolio.tracker.application.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ProblemDetail handleBusinessException(BusinessException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
        HttpStatus.BAD_REQUEST,
        ex.getErrorCode().getMessage()
    );
    problemDetail.setTitle(ex.getErrorCode().getCode());
    problemDetail.setProperty(ex.getErrorCode().getCode(), ex.getErrorCode().getName());
    return problemDetail;
  }

  @ExceptionHandler(RuntimeException.class)
  public ProblemDetail handleRuntimeException(RuntimeException ex) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "An unexpected error occurred"
    );
    problemDetail.setTitle("Internal Server Error");
    problemDetail.setProperty("error", ex.getMessage());
    return problemDetail;
  }
}
