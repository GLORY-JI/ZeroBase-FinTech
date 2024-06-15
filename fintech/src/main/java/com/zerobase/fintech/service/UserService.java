package com.zerobase.fintech.service;

import com.zerobase.fintech.DTO.SignUpDTO;
import com.zerobase.fintech.entity.User;
import com.zerobase.fintech.enums.Authority;
import com.zerobase.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
