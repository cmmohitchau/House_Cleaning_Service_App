package com.cmmohitchau.house_cleaning_service.controller;


import com.cmmohitchau.house_cleaning_service.dto.service.CreateServiceRequest;
import com.cmmohitchau.house_cleaning_service.dto.service.ServiceResponse;
import com.cmmohitchau.house_cleaning_service.model.CleaningService;
import com.cmmohitchau.house_cleaning_service.service.CleaningServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin
public class CleanigServiceController {

    private final CleaningServiceService service;

    public CleanigServiceController(CleaningServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<CleaningService> getAllServices() {
        return service.getAllServices();
    }

    @PostMapping
    public ServiceResponse createService(@RequestBody CreateServiceRequest request) {
        return service.createService(request);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        service.deleteService(id);
    }

    @GetMapping("/{id}")
    public CleaningService getServiceById(@PathVariable Long id) {
        return service.getServiceById(id);
    }

}
