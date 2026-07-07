package com.example.travel.mapper;

import com.example.travel.dto.TravelPackageDTO;
import com.example.travel.entity.TravelPackage;

public class TravelPackageMapper {

    public static TravelPackageDTO toDTO(TravelPackage entity) {

        TravelPackageDTO dto = new TravelPackageDTO();

        dto.setId(entity.getId());
        dto.setPackageName(entity.getPackageName());
        dto.setDescription(entity.getDescription());
        dto.setDestination(entity.getDestination());
        dto.setPrice(entity.getPrice());
        dto.setDurationDays(entity.getDurationDays());

        return dto;
    }

    public static TravelPackage toEntity(TravelPackageDTO dto) {

        TravelPackage entity = new TravelPackage();

        entity.setId(dto.getId());
        entity.setPackageName(dto.getPackageName());
        entity.setDescription(dto.getDescription());
        entity.setDestination(dto.getDestination());
        entity.setPrice(dto.getPrice());
        entity.setDurationDays(dto.getDurationDays());

        return entity;
    }
}