package com.jmj.portfolio.tracker.adapters.out.persistance.repository;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByNameAndEmail(String name, String email);
}
