package com.jmj.portfolio.tracker.adapters.in.controllers;

import com.jmj.portfolio.tracker.application.domain.models.User;
import com.jmj.portfolio.tracker.application.ports.in.UserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserUseCase userService;

  public UserController(UserUseCase userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<Object> registerUser(@RequestParam("username") String username,
                                             @RequestParam("email") String email) {
    userService.registerUser(new User(username,email));
    return ok().build();
  }
  @PostMapping("/deactivate")
  public ResponseEntity<Object> deactivateAccount(@RequestParam("username") String username,
                                                  @RequestParam("email") String email) {
    userService.deactivateAccount(new User(username,email));
    return ok().build();
  }
}
