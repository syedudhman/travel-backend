package com.example.travel.entity;

import com.example.travel.enums.ItineraryStatus;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "trip_itineraries")
public class TripItinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tripName;

    @Enumerated(EnumType.STRING)
    private ItineraryStatus status;

    private boolean aiGenerated;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private SystemAccount account;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private TravelPackage travelPackage;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlannedActivity> activities = new ArrayList<>();

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingReservation> reservations = new ArrayList<>();

    public TripItinerary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public ItineraryStatus getStatus() {
        return status;
    }

    public void setStatus(ItineraryStatus status) {
        this.status = status;
    }

    public boolean isAiGenerated() {
        return aiGenerated;
    }

    public void setAiGenerated(boolean aiGenerated) {
        this.aiGenerated = aiGenerated;
    }

    public SystemAccount getAccount() {
        return account;
    }

    public void setAccount(SystemAccount account) {
        this.account = account;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    public List<PlannedActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<PlannedActivity> activities) {
        this.activities = activities;
    }

    public List<BookingReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<BookingReservation> reservations) {
        this.reservations = reservations;
    }
}