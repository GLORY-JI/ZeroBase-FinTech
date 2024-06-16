package com.zerobase.fintech.service;

import com.zerobase.fintech.DTO.SignUpDTO;
import com.zerobase.fintech.entity.User;
import com.zerobase.fintech.enums.Authority;
import com.zerobase.fintech.exception.ExistEmailException;
import com.zerobase.fintech.model.ResponseError;
import com.zerobase.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void signUp(SignUpDTO signUpDTO) {

        User user = User.builder()
                .email(signUpDTO.getEmail())
                .password(signUpDTO.getPassword())
                .userName(signUpDTO.getUserName())
                .phoneNumber(signUpDTO.getPhoneNumber())
                .build();
        user.setRole(Authority.USER);

        userRepository.save(user);
    }

    public List<ResponseError> validateSignUp(SignUpDTO signUpDTO, Errors errors) {
        List<ResponseError> responseErrorList = new ArrayList<>();

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> responseErrorList.add(ResponseError.of((FieldError) e)));
        }

        if (userRepository.countByEmail(signUpDTO.getEmail()) > 0) {
            throw new ExistEmailException("이미 존재하는 이메일");
        }

        return responseErrorList;
    }

}
