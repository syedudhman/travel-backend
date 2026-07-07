package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travel.entity.TravelPackage;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {

}