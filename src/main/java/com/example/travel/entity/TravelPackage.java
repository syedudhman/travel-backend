package com.example.travel.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "travel_packages")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String packageName;

    @Column(length = 1000)
    private String description;

    private String destination;

    private double price;

    private int durationDays;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripItinerary> tripItineraries = new ArrayList<>();

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingReservation> bookingReservations = new ArrayList<>();

    public TravelPackage() {
    }

    public TravelPackage(Long id, String packageName, String description,
                         String destination, double price, int durationDays) {
        this.id = id;
        this.packageName = packageName;
        this.description = description;
        this.destination = destination;
        this.price = price;
        this.durationDays = durationDays;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPackageName() { return packageName; }
    public void setPackageName(String packageName) { this.packageName = packageName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getDurationDays() { return durationDays; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }

    public List<TripItinerary> getTripItineraries() { return tripItineraries; }
    public void setTripItineraries(List<TripItinerary> tripItineraries) { this.tripItineraries = tripItineraries; }

    public List<BookingReservation> getBookingReservations() { return bookingReservations; }
    public void setBookingReservations(List<BookingReservation> bookingReservations) { this.bookingReservations = bookingReservations; }
}