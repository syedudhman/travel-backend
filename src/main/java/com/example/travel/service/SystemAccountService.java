package com.example.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travel.dto.SystemAccountDTO;
import com.example.travel.entity.SystemAccount;
import com.example.travel.exception.EmailAlreadyExistsException;
import com.example.travel.exception.ResourceNotFoundException;
import com.example.travel.mapper.SystemAccountMapper;
import com.example.travel.repository.SystemAccountRepository;

@Service
public class SystemAccountService {

    @Autowired
    private SystemAccountRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SystemAccountDTO addAccount(SystemAccountDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        SystemAccount account = SystemAccountMapper.toEntity(dto);

        account.setPassword(passwordEncoder.encode(dto.getPassword()));

        account = repository.save(account);

        return SystemAccountMapper.toDTO(account);
    }

    public List<SystemAccountDTO> getAllAccounts() {
                return repository.findAll()
                .stream()
                .map(SystemAccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SystemAccountDTO getAccountById(Long id) {

        SystemAccount account = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Account not found with ID : " + id));

        return SystemAccountMapper.toDTO(account);
    }

    public SystemAccountDTO updateAccount(Long id, SystemAccountDTO dto) {

        SystemAccount account = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Account not found with ID : " + id));

        account.setFullName(dto.getFullName());
        account.setEmail(dto.getEmail());

        account.setPassword(passwordEncoder.encode(dto.getPassword()));

        account.setRole(dto.getRole());
        account.setActive(dto.isActive());

        account = repository.save(account);

        return SystemAccountMapper.toDTO(account);
    }

    public String deleteAccount(Long id) {

        SystemAccount account = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID : " + id));

        repository.delete(account);

        return "Account Deleted Successfully";
    }
}