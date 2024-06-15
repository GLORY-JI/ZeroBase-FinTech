package com.zerobase.fintech.repository;

import com.zerobase.fintech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    int countByEmail(String email);
    boolean existsByUserId(Long id);
}
