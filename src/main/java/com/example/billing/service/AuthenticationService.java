package com.example.billing.service;

import com.example.billing.model.LoginUserDto;
import com.example.billing.model.RegisterUserDto;
import com.example.billing.repository.UserRepository;
import com.example.billing.repository.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;


    public User signup(RegisterUserDto input) {
        User user = modelMapper.map(input, User.class);
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        System.out.println(user);
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email()).orElseThrow();
    }
}

