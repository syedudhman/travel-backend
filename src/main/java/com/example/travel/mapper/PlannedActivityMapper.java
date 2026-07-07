package com.example.travel.mapper;

import com.example.travel.dto.PlannedActivityDTO;
import com.example.travel.entity.PlannedActivity;

public class PlannedActivityMapper {

    public static PlannedActivityDTO toDTO(PlannedActivity entity) {

        PlannedActivityDTO dto = new PlannedActivityDTO();

        dto.setId(entity.getId());
        dto.setActivityName(entity.getActivityName());
        dto.setLocation(entity.getLocation());
        dto.setScheduledAt(entity.getScheduledAt());
        dto.setEstimatedCost(entity.getEstimatedCost());
        dto.setRequiresBooking(entity.isRequiresBooking());

        if (entity.getItinerary() != null) {
            dto.setItineraryId(entity.getItinerary().getId());
        }

        return dto;
    }
}