package com.example.travel.entity;

import java.time.LocalDateTime;

import com.example.travel.enums.BookingStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_reservations")
public class BookingReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingReference;

    private LocalDateTime reservedAt;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private double totalPaid;

    @ManyToOne
    @JoinColumn(name = "itinerary_id")
    private TripItinerary itinerary;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private TravelPackage travelPackage;

    public BookingReservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public TripItinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(TripItinerary itinerary) {
        this.itinerary = itinerary;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }
}