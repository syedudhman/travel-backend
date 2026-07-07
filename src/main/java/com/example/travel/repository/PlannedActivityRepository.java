package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travel.entity.PlannedActivity;

@Repository
public interface PlannedActivityRepository extends JpaRepository<PlannedActivity, Long> {

}