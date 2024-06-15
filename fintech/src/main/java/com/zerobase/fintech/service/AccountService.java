package com.zerobase.fintech.service;

import com.zerobase.fintech.DTO.AccountDTO;
import com.zerobase.fintech.entity.Account;
import com.zerobase.fintech.entity.User;
import com.zerobase.fintech.exception.UserNotFoundException;
import com.zerobase.fintech.model.ResponseError;
import com.zerobase.fintech.repository.AccountRepository;
import com.zerobase.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    public List<ResponseError> validateAccount(AccountDTO accountDTO, Errors errors) {
        List<ResponseError> responseErrorList = new ArrayList<>();

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> responseErrorList.add(ResponseError.of((FieldError) e)));
        }

        if(!userRepository.existsByUserId(accountDTO.getId())) {
            throw new UserNotFoundException("ID에 해당하는 정보가 존재하지 않습니다.");
        }

        return responseErrorList;
    }

    public Account createAccount(AccountDTO accountDTO) {

        String accountNumber = generateUniqueAccountNumber();

        Account account = Account.builder()
                .user(User.builder()
                        .userId(accountDTO.getId())
                        .build())
                .accountNumber(accountNumber)
                .balance(accountDTO.getInitialBalance())
                .build();

        return accountRepository.save(account);
    }

    private String generateUniqueAccountNumber() {
        Random random = new Random();
        String accountNumber;
        do {
            accountNumber = String.format("%020d", random.nextLong() & Long.MAX_VALUE);
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }

}
