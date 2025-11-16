package com.cmmohitchau.house_cleaning_service.service.impl;

import com.cmmohitchau.house_cleaning_service.dto.booking.CreateBookingRequest;
import com.cmmohitchau.house_cleaning_service.model.Booking;
import com.cmmohitchau.house_cleaning_service.model.BookingStatus;
import com.cmmohitchau.house_cleaning_service.model.CleaningService;
import com.cmmohitchau.house_cleaning_service.model.User;
import com.cmmohitchau.house_cleaning_service.repository.BookingRepository;
import com.cmmohitchau.house_cleaning_service.repository.CleaningServiceRepository;
import com.cmmohitchau.house_cleaning_service.repository.UserRepository;
import com.cmmohitchau.house_cleaning_service.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final CleaningServiceRepository serviceRepo;

    public BookingServiceImpl(
            BookingRepository bookingRepo,
            UserRepository userRepo,
            CleaningServiceRepository serviceRepo) {

        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.serviceRepo = serviceRepo;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }
    @Override
    public Booking createBooking(CreateBookingRequest request) {

        User user = userRepo.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        CleaningService service = serviceRepo.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        Booking booking = new Booking();
        booking.setCustomer(user);
        booking.setService(service);
        booking.setAddress(request.getAddress());
        booking.setBookingDateTime(request.getBookingDateTime());
        booking.setStatus(BookingStatus.PENDING);
        booking.setCreatedAt(LocalDateTime.now());

        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
        User user = userRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepo.findByCustomer(user);
    }

    @Override
    public void deletById(Long id) {
        bookingRepo.deleteById(id);
    }

}
