package com.example.travel.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "planned_activities")
public class PlannedActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityName;

    private String location;

    private LocalDateTime scheduledAt;

    private double estimatedCost;

    private boolean requiresBooking;

    @ManyToOne
    @JoinColumn(name = "itinerary_id")
    private TripItinerary itinerary;

    public PlannedActivity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public boolean isRequiresBooking() {
        return requiresBooking;
    }

    public void setRequiresBooking(boolean requiresBooking) {
        this.requiresBooking = requiresBooking;
    }

    public TripItinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(TripItinerary itinerary) {
        this.itinerary = itinerary;
    }
}