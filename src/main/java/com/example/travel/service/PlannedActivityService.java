package com.example.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.dto.PlannedActivityDTO;
import com.example.travel.entity.PlannedActivity;
import com.example.travel.entity.TripItinerary;
import com.example.travel.exception.ResourceNotFoundException;
import com.example.travel.mapper.PlannedActivityMapper;
import com.example.travel.repository.PlannedActivityRepository;
import com.example.travel.repository.TripItineraryRepository;

@Service
public class PlannedActivityService {

    @Autowired
    private PlannedActivityRepository repository;

    @Autowired
    private TripItineraryRepository itineraryRepository;

    public PlannedActivityDTO addActivity(PlannedActivityDTO dto) {

        TripItinerary itinerary = itineraryRepository.findById(dto.getItineraryId())
                .orElseThrow(() -> new ResourceNotFoundException("Trip Itinerary Not Found"));

        PlannedActivity activity = new PlannedActivity();

        activity.setActivityName(dto.getActivityName());
        activity.setLocation(dto.getLocation());
        activity.setScheduledAt(dto.getScheduledAt());
        activity.setEstimatedCost(dto.getEstimatedCost());
        activity.setRequiresBooking(dto.isRequiresBooking());
        activity.setItinerary(itinerary);

        activity = repository.save(activity);

        return PlannedActivityMapper.toDTO(activity);
    }

    public List<PlannedActivityDTO> getAllActivities() {

        return repository.findAll()
                .stream()
                .map(PlannedActivityMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlannedActivityDTO getActivityById(Long id) {

        PlannedActivity activity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity Not Found"));

        return PlannedActivityMapper.toDTO(activity);
    }

    public PlannedActivityDTO updateActivity(Long id, PlannedActivityDTO dto) {

        PlannedActivity activity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity Not Found"));

        TripItinerary itinerary = itineraryRepository.findById(dto.getItineraryId())
                .orElseThrow(() -> new ResourceNotFoundException("Trip Itinerary Not Found"));

        activity.setActivityName(dto.getActivityName());
        activity.setLocation(dto.getLocation());
        activity.setScheduledAt(dto.getScheduledAt());
        activity.setEstimatedCost(dto.getEstimatedCost());
        activity.setRequiresBooking(dto.isRequiresBooking());
        activity.setItinerary(itinerary);

        activity = repository.save(activity);

        return PlannedActivityMapper.toDTO(activity);
    }

    public String deleteActivity(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Activity Not Found");
        }

        repository.deleteById(id);

        return "Activity Deleted Successfully";
    }
}