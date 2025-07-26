package com.jmj.portfolio.tracker.application.domain.models;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
  private String name;
  private UUID userId;
  private String email;
}
