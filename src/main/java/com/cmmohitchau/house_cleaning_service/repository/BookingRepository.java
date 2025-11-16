package com.cmmohitchau.house_cleaning_service.repository;
import com.cmmohitchau.house_cleaning_service.model.Booking;
import com.cmmohitchau.house_cleaning_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking , Long> {
    List<Booking> findByCustomer(User user);
}
