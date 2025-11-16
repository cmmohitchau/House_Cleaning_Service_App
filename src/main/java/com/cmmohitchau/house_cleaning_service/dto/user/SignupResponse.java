package com.cmmohitchau.house_cleaning_service.dto.user;

public class SignupResponse {
    private String name;
    private String email;
    private Long id;
    public SignupResponse() {}
    public SignupResponse(String name , String email , Long id) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
