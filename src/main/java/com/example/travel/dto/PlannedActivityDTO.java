package com.example.travel.dto;

import java.time.LocalDateTime;

public class PlannedActivityDTO {

    private Long id;

    private String activityName;

    private String location;

    private LocalDateTime scheduledAt;

    private double estimatedCost;

    private boolean requiresBooking;

    private Long itineraryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public PlannedActivityDTO() {
    }

    // Generate all getters and setters using VS Code
}