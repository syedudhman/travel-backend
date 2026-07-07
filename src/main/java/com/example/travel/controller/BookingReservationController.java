package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.travel.dto.BookingReservationDTO;
import com.example.travel.service.BookingReservationService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/reservations")
public class BookingReservationController {

    @Autowired
    private BookingReservationService service;

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @PostMapping("/add")
    public BookingReservationDTO addReservation(@RequestBody BookingReservationDTO dto) {
        return service.addReservation(dto);
    }

    @GetMapping("/all")
    public List<BookingReservationDTO> getAllReservations() {
        return service.getAllReservations();
    }

    @GetMapping("/{id}")
    public BookingReservationDTO getReservationById(@PathVariable Long id) {
        return service.getReservationById(id);
    }

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @PutMapping("/update/{id}")
    public BookingReservationDTO updateReservation(@PathVariable Long id,  @RequestBody BookingReservationDTO dto) {
        return service.updateReservation(id, dto);
    }

    @PreAuthorize("hasAnyRole('AGENCY_MANAGER', 'TRAVEL_AGENT')")
    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        return service.deleteReservation(id);
    }
}