package com.cmmohitchau.house_cleaning_service.dto.user;

public class UserDto {

    private Long id;
    private String email;
    private String name;

    public UserDto() {};
    public UserDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
}
