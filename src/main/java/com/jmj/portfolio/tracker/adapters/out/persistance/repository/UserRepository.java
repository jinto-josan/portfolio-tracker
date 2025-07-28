package com.jmj.portfolio.tracker.adapters.out.persistance.repository;

import com.jmj.portfolio.tracker.adapters.out.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
