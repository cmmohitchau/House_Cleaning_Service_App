package com.cmmohitchau.house_cleaning_service.dto.user;

import com.cmmohitchau.house_cleaning_service.model.User;

public class SignupResponse {
    private UserDto user;

    public SignupResponse(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
