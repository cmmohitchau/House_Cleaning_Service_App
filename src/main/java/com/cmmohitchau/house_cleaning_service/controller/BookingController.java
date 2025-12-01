package com.cmmohitchau.house_cleaning_service.controller;

import com.cmmohitchau.house_cleaning_service.dto.booking.CreateBookingRequest;
import com.cmmohitchau.house_cleaning_service.model.Booking;
import com.cmmohitchau.house_cleaning_service.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    private  final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBooking() {

        return bookingService.getAllBooking();
    }

    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomer(@PathVariable Long customerId) {
        return bookingService.getBookingsByCustomer(customerId);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId) {
        bookingService.deletById(bookingId);
    }
}
