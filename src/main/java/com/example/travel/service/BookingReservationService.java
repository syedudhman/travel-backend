package com.example.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.dto.BookingReservationDTO;
import com.example.travel.entity.BookingReservation;
import com.example.travel.entity.TravelPackage;
import com.example.travel.entity.TripItinerary;
import com.example.travel.exception.ResourceNotFoundException;
import com.example.travel.mapper.BookingReservationMapper;
import com.example.travel.repository.BookingReservationRepository;
import com.example.travel.repository.TravelPackageRepository;
import com.example.travel.repository.TripItineraryRepository;

@Service
public class BookingReservationService {

    @Autowired
    private BookingReservationRepository repository;

    @Autowired
    private TripItineraryRepository itineraryRepository;

    @Autowired
    private TravelPackageRepository packageRepository;

    
    public BookingReservationDTO addReservation(BookingReservationDTO dto) {

        TripItinerary itinerary = itineraryRepository.findById(dto.getItineraryId())
                .orElseThrow(() -> new ResourceNotFoundException("Trip Itinerary Not Found"));

        TravelPackage travelPackage = packageRepository.findById(dto.getTravelPackageId())
                .orElseThrow(() -> new ResourceNotFoundException("Travel Package Not Found"));

        BookingReservation reservation = new BookingReservation();

        reservation.setBookingReference(dto.getBookingReference());
        reservation.setReservedAt(dto.getReservedAt());
        reservation.setStatus(dto.getStatus());
        reservation.setTotalPaid(dto.getTotalPaid());
        reservation.setItinerary(itinerary);
        reservation.setTravelPackage(travelPackage);

        reservation = repository.save(reservation);

        return BookingReservationMapper.toDTO(reservation);
    }

    
    public List<BookingReservationDTO> getAllReservations() {

        return repository.findAll()
                .stream()
                .map(BookingReservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    
    public BookingReservationDTO getReservationById(Long id) {

        BookingReservation reservation = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation Not Found"));

        return BookingReservationMapper.toDTO(reservation);
    }

    
    public BookingReservationDTO updateReservation(Long id, BookingReservationDTO dto) {

        BookingReservation reservation = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation Not Found"));

        TripItinerary itinerary = itineraryRepository.findById(dto.getItineraryId())
                .orElseThrow(() -> new ResourceNotFoundException("Trip Itinerary Not Found"));

        TravelPackage travelPackage = packageRepository.findById(dto.getTravelPackageId())
                .orElseThrow(() -> new ResourceNotFoundException("Travel Package Not Found"));

        reservation.setBookingReference(dto.getBookingReference());
        reservation.setReservedAt(dto.getReservedAt());
        reservation.setStatus(dto.getStatus());
        reservation.setTotalPaid(dto.getTotalPaid());
        reservation.setItinerary(itinerary);
        reservation.setTravelPackage(travelPackage);

        reservation = repository.save(reservation);

        return BookingReservationMapper.toDTO(reservation);
    }

    
    public String deleteReservation(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation Not Found");
        }

        repository.deleteById(id);

        return "Booking Reservation Deleted Successfully";
    }
}