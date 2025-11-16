package com.cmmohitchau.house_cleaning_service.repository;
import com.cmmohitchau.house_cleaning_service.model.CleaningService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleaningServiceRepository extends JpaRepository<CleaningService , Long> {


}
