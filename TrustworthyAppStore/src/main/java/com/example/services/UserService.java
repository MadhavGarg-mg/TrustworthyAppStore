package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String email, String rawPassword) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already registered.");
        }
        String hashedPassword = passwordEncoder.encode(rawPassword);
        User user = new User(email, hashedPassword);
        userRepository.save(user);
    }

    public boolean validateUser(String email, String rawPassword) {
        return userRepository.findByEmail(email)
                .map(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElse(false);
    }
}
