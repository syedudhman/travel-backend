package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.travel.dto.TravelPackageDTO;
import com.example.travel.service.TravelPackageService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService service;

    @PreAuthorize("hasRole('AGENCY_MANAGER')")
    @PostMapping("/add")
    public TravelPackageDTO addPackage(@RequestBody TravelPackageDTO dto) {
        return service.addPackage(dto);
    }

    @GetMapping("/all")
    public List<TravelPackageDTO> getAllPackages() {
        return service.getAllPackages();
    }

    @GetMapping("/{id}")
    public TravelPackageDTO getPackageById(@PathVariable Long id) {
        return service.getPackageById(id);
    }

    @PreAuthorize("hasRole('AGENCY_MANAGER')")
    @PutMapping("/update/{id}")
    public TravelPackageDTO updatePackage(@PathVariable Long id, @RequestBody TravelPackageDTO dto) {
        return service.updatePackage(id, dto);
    }

    @PreAuthorize("hasRole('AGENCY_MANAGER')")
    @DeleteMapping("/delete/{id}")
    public String deletePackage(@PathVariable Long id) {
        return service.deletePackage(id);
    }
}