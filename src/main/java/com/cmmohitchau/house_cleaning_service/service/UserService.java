package com.cmmohitchau.house_cleaning_service.service;

import com.cmmohitchau.house_cleaning_service.dto.user.LoginRequest;
import com.cmmohitchau.house_cleaning_service.dto.user.LoginResponse;
import com.cmmohitchau.house_cleaning_service.dto.user.SignupRequest;
import com.cmmohitchau.house_cleaning_service.dto.user.SignupResponse;
import com.cmmohitchau.house_cleaning_service.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    SignupResponse signup(SignupRequest request);
    LoginResponse login(LoginRequest request);
    User getUserByEmail(String email);
    List<User> getUsers();
}
