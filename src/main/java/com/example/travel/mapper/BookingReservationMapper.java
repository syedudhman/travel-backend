package com.example.travel.mapper;

import com.example.travel.dto.BookingReservationDTO;
import com.example.travel.entity.BookingReservation;

public class BookingReservationMapper {

    public static BookingReservationDTO toDTO(BookingReservation entity) {

        BookingReservationDTO dto = new BookingReservationDTO();

        dto.setId(entity.getId());
        dto.setBookingReference(entity.getBookingReference());
        dto.setReservedAt(entity.getReservedAt());
        dto.setStatus(entity.getStatus());
        dto.setTotalPaid(entity.getTotalPaid());

        if (entity.getItinerary() != null) {
            dto.setItineraryId(entity.getItinerary().getId());
        }

        if (entity.getTravelPackage() != null) {
            dto.setTravelPackageId(entity.getTravelPackage().getId());
        }

        return dto;
    }
}