package com.cmmohitchau.house_cleaning_service.dto.user;

import com.cmmohitchau.house_cleaning_service.model.Role;

public class UserResponse {

    private String token;
    private String role;

    public UserResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
