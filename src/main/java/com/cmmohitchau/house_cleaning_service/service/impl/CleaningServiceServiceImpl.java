package com.cmmohitchau.house_cleaning_service.service.impl;

import com.cmmohitchau.house_cleaning_service.dto.service.CreateServiceRequest;
import com.cmmohitchau.house_cleaning_service.dto.service.ServiceResponse;
import com.cmmohitchau.house_cleaning_service.model.CleaningService;
import com.cmmohitchau.house_cleaning_service.repository.CleaningServiceRepository;
import com.cmmohitchau.house_cleaning_service.service.CleaningServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleaningServiceServiceImpl implements CleaningServiceService {

    private final CleaningServiceRepository repository;

    public CleaningServiceServiceImpl(CleaningServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CleaningService> getAllServices() {
        return repository.findAll();
    }

    @Override
    public CleaningService getServiceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    @Override
    public ServiceResponse createService(CreateServiceRequest request) {

        CleaningService service = new CleaningService();

        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setPrice(request.getPrice());
        service.setDurationMinutes(request.getDurationMinutes());

        CleaningService saved = repository.save(service);

        return new ServiceResponse(saved.getId() , saved.getName() ,saved.getDescription() , saved.getPrice() , saved.getDurationMinutes());
    }

    @Override
    public void deleteService(Long id) {
        repository.deleteById(id);
    }


}
