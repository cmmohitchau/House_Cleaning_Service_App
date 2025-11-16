package com.cmmohitchau.house_cleaning_service.dto.booking;

import com.cmmohitchau.house_cleaning_service.model.BookingStatus;

import java.time.LocalDateTime;

public class BookingResponseDTO {

    private Long id;
    private String serviceName;
    private Double price;
    private LocalDateTime bookingDateTime;
    private String address;
    private String status;

    public BookingResponseDTO(Long id, Double price, String serviceName, LocalDateTime bookingDateTime, String address, String status) {
        this.id = id;
        this.price = price;
        this.serviceName = serviceName;
        this.bookingDateTime = bookingDateTime;
        this.address = address;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
