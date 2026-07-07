package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.travel.dto.TripItineraryDTO;
import com.example.travel.service.TripItineraryService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PostAuthorize;

@RestController
@RequestMapping("/trip-itineraries")
public class TripItineraryController {

    @Autowired
    private TripItineraryService service;

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @PostMapping("/add")
    public TripItineraryDTO addTripItinerary(@RequestBody TripItineraryDTO dto) {
        return service.addTripItinerary(dto);
    }

    @PostFilter("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT') or filterObject.accountId == principal.id")
    @GetMapping("/all")
    public List<TripItineraryDTO> getAllTripItineraries() {
        return service.getAllTripItineraries();
    }

    @PostAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT') or returnObject.accountId == principal.id")
    @GetMapping("/{id}")
    public TripItineraryDTO getTripItineraryById(@PathVariable Long id) {
        return service.getTripItineraryById(id);
    }

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @PutMapping("/update/{id}")
    public TripItineraryDTO updateTripItinerary(@PathVariable Long id,@RequestBody TripItineraryDTO dto) {
        return service.updateTripItinerary(id, dto);
    }

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @DeleteMapping("/delete/{id}")
    public String deleteTripItinerary(@PathVariable Long id) {
        return service.deleteTripItinerary(id);
    }
}