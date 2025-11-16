package com.cmmohitchau.house_cleaning_service.service;

import com.cmmohitchau.house_cleaning_service.dto.booking.CreateBookingRequest;
import com.cmmohitchau.house_cleaning_service.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();
    Booking createBooking(CreateBookingRequest request);
    List<Booking> getBookingsByCustomer(Long customerId);
    void deletById(Long id);
}
