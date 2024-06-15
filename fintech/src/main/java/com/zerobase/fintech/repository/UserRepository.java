package com.zerobase.fintech.repository;

import com.zerobase.fintech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
