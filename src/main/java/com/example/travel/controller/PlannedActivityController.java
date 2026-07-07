    package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.travel.dto.PlannedActivityDTO;
import com.example.travel.service.PlannedActivityService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/activities")
public class PlannedActivityController {

    @Autowired
    private PlannedActivityService service;

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @PostMapping("/add")
    public PlannedActivityDTO addActivity(@RequestBody PlannedActivityDTO dto) {
        return service.addActivity(dto);
    }

    @GetMapping("/all")
    public List<PlannedActivityDTO> getAllActivities() {
        return service.getAllActivities();
    }

    @GetMapping("/{id}")
    public PlannedActivityDTO getActivityById(@PathVariable Long id) {
        return service.getActivityById(id);
    }

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @PutMapping("/update/{id}")
    public PlannedActivityDTO updateActivity(@PathVariable Long id, @RequestBody PlannedActivityDTO dto) {
        return service.updateActivity(id, dto);
    }

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @DeleteMapping("/delete/{id}")
    public String deleteActivity(@PathVariable Long id) {
        return service.deleteActivity(id);
    }
}