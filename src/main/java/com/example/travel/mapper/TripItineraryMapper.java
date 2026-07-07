package com.example.travel.mapper;

import com.example.travel.dto.TripItineraryDTO;
import com.example.travel.entity.TripItinerary;

public class TripItineraryMapper {

    public static TripItineraryDTO toDTO(TripItinerary entity) {

        TripItineraryDTO dto = new TripItineraryDTO();

        dto.setId(entity.getId());
        dto.setTripName(entity.getTripName());
        dto.setStatus(entity.getStatus());
        dto.setAiGenerated(entity.isAiGenerated());

        if(entity.getAccount()!=null)
            dto.setAccountId(entity.getAccount().getId());

        if(entity.getTravelPackage()!=null)
            dto.setTravelPackageId(entity.getTravelPackage().getId());

        return dto;
    }
}