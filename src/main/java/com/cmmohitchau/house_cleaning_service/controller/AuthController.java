package com.cmmohitchau.house_cleaning_service.controller;


import com.cmmohitchau.house_cleaning_service.dto.user.LoginRequest;
import com.cmmohitchau.house_cleaning_service.dto.user.LoginResponse;
import com.cmmohitchau.house_cleaning_service.dto.user.SignupRequest;
import com.cmmohitchau.house_cleaning_service.dto.user.SignupResponse;
import com.cmmohitchau.house_cleaning_service.model.User;
import com.cmmohitchau.house_cleaning_service.repository.UserRepository;
import com.cmmohitchau.house_cleaning_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin

public class AuthController {

    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        SignupResponse response = userService.signup(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}