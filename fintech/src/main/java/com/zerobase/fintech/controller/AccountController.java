package com.zerobase.fintech.controller;

import com.zerobase.fintech.DTO.AccountDTO;
import com.zerobase.fintech.model.ResponseError;
import com.zerobase.fintech.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/accounts")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody @Valid AccountDTO accountDTO, Errors errors) {

        List<ResponseError> responseErrorList = accountService.validateAccount(accountDTO, errors);

        if (!responseErrorList.isEmpty()) {
            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        accountService.createAccount(accountDTO);

        return ResponseEntity.ok().build();
    }

}
