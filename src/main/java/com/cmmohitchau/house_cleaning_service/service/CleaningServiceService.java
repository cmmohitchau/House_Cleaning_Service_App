package com.cmmohitchau.house_cleaning_service.service;

import com.cmmohitchau.house_cleaning_service.dto.service.CreateServiceRequest;
import com.cmmohitchau.house_cleaning_service.dto.service.ServiceResponse;
import com.cmmohitchau.house_cleaning_service.model.CleaningService;

import java.util.List;

public interface CleaningServiceService {
    List<CleaningService> getAllServices();
    CleaningService getServiceById(Long id);
    ServiceResponse createService(CreateServiceRequest request);
    void deleteService(Long id);
}