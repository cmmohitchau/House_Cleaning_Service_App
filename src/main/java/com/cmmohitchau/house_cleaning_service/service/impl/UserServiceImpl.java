package com.cmmohitchau.house_cleaning_service.service.impl;

import com.cmmohitchau.house_cleaning_service.dto.user.LoginRequest;
import com.cmmohitchau.house_cleaning_service.dto.user.LoginResponse;
import com.cmmohitchau.house_cleaning_service.dto.user.SignupRequest;
import com.cmmohitchau.house_cleaning_service.dto.user.SignupResponse;
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

        if(userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPasswordHash(request.getPassword());

        User saved = userRepo.save(user);

        return new SignupResponse(saved.getName() , saved.getEmail() , saved.getId());
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Optional<User> optionalUser = userRepo.findByEmail(request.getEmail());

        if(optionalUser.isEmpty()) {
            throw new RuntimeException("Email is not registered");
        }

        User user = optionalUser.get();

        if(!user.getPasswordHash().equals(request.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

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
