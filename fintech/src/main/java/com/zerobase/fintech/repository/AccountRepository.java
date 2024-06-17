package com.zerobase.fintech.repository;

import com.zerobase.fintech.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByAccountNumber(String accountNumber);

    boolean existsByAccountId(Long accountId);

    Account getByAccountId(Long id);

}
