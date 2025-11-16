package com.cmmohitchau.house_cleaning_service.dto.service;

public class ServiceResponse {

    public Long id;
    public String name;
    public String description;
    public Double price;
    public Integer durationMinutes;

    public ServiceResponse(Long id, String name, String description,
                           Double price, Integer durationMinutes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

}


