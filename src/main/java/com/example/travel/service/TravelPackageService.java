package com.example.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.dto.TravelPackageDTO;
import com.example.travel.entity.TravelPackage;
import com.example.travel.exception.ResourceNotFoundException;
import com.example.travel.mapper.TravelPackageMapper;
import com.example.travel.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

    @Autowired
    private TravelPackageRepository repository;


    public TravelPackageDTO addPackage(TravelPackageDTO dto) {

        TravelPackage entity = TravelPackageMapper.toEntity(dto);

        entity = repository.save(entity);

        return TravelPackageMapper.toDTO(entity);
    }

    
    public List<TravelPackageDTO> getAllPackages() {

        return repository.findAll()
                .stream()
                .map(TravelPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    
    public TravelPackageDTO getPackageById(Long id) {

        TravelPackage entity = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Package not found with ID : " + id));

        return TravelPackageMapper.toDTO(entity);
    }

    public TravelPackageDTO updatePackage(Long id, TravelPackageDTO dto) {

        TravelPackage entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Package not found with ID : " + id));

        entity.setPackageName(dto.getPackageName());
        entity.setDescription(dto.getDescription());
        entity.setDestination(dto.getDestination());
        entity.setPrice(dto.getPrice());
        entity.setDurationDays(dto.getDurationDays());

        entity = repository.save(entity);

        return TravelPackageMapper.toDTO(entity);
    }

    public String deletePackage(Long id) {

        TravelPackage entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Package not found with ID : " + id));

        repository.delete(entity);

        return "Travel Package Deleted Successfully";
    }
}