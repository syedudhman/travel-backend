package com.example.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.dto.TripItineraryDTO;
import com.example.travel.entity.SystemAccount;
import com.example.travel.entity.TravelPackage;
import com.example.travel.entity.TripItinerary;
import com.example.travel.exception.ResourceNotFoundException;
import com.example.travel.mapper.TripItineraryMapper;
import com.example.travel.repository.SystemAccountRepository;
import com.example.travel.repository.TravelPackageRepository;
import com.example.travel.repository.TripItineraryRepository;

@Service
public class TripItineraryService {

    @Autowired
    private TripItineraryRepository repository;

    @Autowired
    private SystemAccountRepository accountRepository;

    @Autowired
    private TravelPackageRepository packageRepository;

    public TripItineraryDTO addTripItinerary(TripItineraryDTO dto) {

        SystemAccount account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account Not Found"));

        TravelPackage travelPackage = packageRepository.findById(dto.getTravelPackageId())
                .orElseThrow(() -> new ResourceNotFoundException("Package Not Found"));

        TripItinerary itinerary = new TripItinerary();

        itinerary.setTripName(dto.getTripName());
        itinerary.setStatus(dto.getStatus());
        itinerary.setAiGenerated(dto.isAiGenerated());
        itinerary.setAccount(account);
        itinerary.setTravelPackage(travelPackage);

        itinerary = repository.save(itinerary);

        return TripItineraryMapper.toDTO(itinerary);
    }

    public List<TripItineraryDTO> getAllTripItineraries() {

        return repository.findAll()
                .stream()
                .map(TripItineraryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TripItineraryDTO getTripItineraryById(Long id) {

        TripItinerary itinerary = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Trip Itinerary Not Found"));

        return TripItineraryMapper.toDTO(itinerary);
    }

    public TripItineraryDTO updateTripItinerary(Long id, TripItineraryDTO dto) {

        TripItinerary itinerary = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Trip Itinerary Not Found"));

        SystemAccount account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account Not Found"));

        TravelPackage travelPackage = packageRepository.findById(dto.getTravelPackageId())
                .orElseThrow(() -> new ResourceNotFoundException("Package Not Found"));

        itinerary.setTripName(dto.getTripName());
        itinerary.setStatus(dto.getStatus());
        itinerary.setAiGenerated(dto.isAiGenerated());
        itinerary.setAccount(account);
        itinerary.setTravelPackage(travelPackage);

        itinerary = repository.save(itinerary);

        return TripItineraryMapper.toDTO(itinerary);
    }

    public String deleteTripItinerary(Long id) {

        TripItinerary itinerary = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Trip Itinerary Not Found"));

        repository.delete(itinerary);

        return "Trip Itinerary Deleted Successfully";
    }
}