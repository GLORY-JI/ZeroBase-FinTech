package com.zerobase.fintech.controller;

import com.zerobase.fintech.DTO.SignUpDTO;
import com.zerobase.fintech.exception.ExistEmailException;
import com.zerobase.fintech.model.ResponseError;
import com.zerobase.fintech.repository.UserRepository;
import com.zerobase.fintech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;


    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDTO signUpDTO, Errors errors) {

        List<ResponseError> responseErrorList = new ArrayList<>();

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });

            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        if (userRepository.countByEmail(signUpDTO.getEmail()) > 0) {
            throw new ExistEmailException("이미 존재하는 이메일");
        }

        userService.signUp(signUpDTO);

        return ResponseEntity.ok().build();
    }

}
