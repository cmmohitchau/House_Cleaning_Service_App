package com.cmmohitchau.house_cleaning_service.service.impl;

import com.cmmohitchau.house_cleaning_service.dto.user.*;
import com.cmmohitchau.house_cleaning_service.model.User;
import com.cmmohitchau.house_cleaning_service.repository.UserRepository;
import com.cmmohitchau.house_cleaning_service.service.BookingService;
import com.cmmohitchau.house_cleaning_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public SignupResponse signup(SignupRequest request) {

        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword());

        User savedUser = userRepo.save(user);

        UserDto userDto = new UserDto(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getName()
        );

        return new SignupResponse(userDto);

    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDto userDto = new UserDto(
                user.getId(),
                user.getEmail(),
                user.getName()
        );

        return new LoginResponse(userDto);
    }




    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
