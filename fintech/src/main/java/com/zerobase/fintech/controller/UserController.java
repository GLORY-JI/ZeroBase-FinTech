package com.zerobase.fintech.controller;

import com.zerobase.fintech.DTO.SignUpDTO;
import com.zerobase.fintech.model.ResponseError;
import com.zerobase.fintech.repository.UserRepository;
import com.zerobase.fintech.service.UserService;
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
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDTO signUpDTO, Errors errors) {

        List<ResponseError> responseErrorList = userService.validateSignUp(signUpDTO, errors);

        if (!responseErrorList.isEmpty()) {
            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        userService.signUp(signUpDTO);

        return ResponseEntity.ok().build();
    }

}
