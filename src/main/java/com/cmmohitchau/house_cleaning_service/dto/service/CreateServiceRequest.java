package com.cmmohitchau.house_cleaning_service.dto.service;

import com.cmmohitchau.house_cleaning_service.dto.booking.CreateBookingRequest;

public class CreateServiceRequest {

    private String name;
    private String description;
    private Double price;
    private Integer durationMinutes;

    public CreateServiceRequest() {}

    public CreateServiceRequest( String name, String description, Double price, Integer durationMinutes) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
