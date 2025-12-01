package com.cmmohitchau.house_cleaning_service.dto.user;

public class LoginResponse {
    private UserDto user;

    public LoginResponse() {};
    public LoginResponse(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
