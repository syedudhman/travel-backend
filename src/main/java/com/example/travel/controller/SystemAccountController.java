package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.travel.dto.SystemAccountDTO;
import com.example.travel.service.SystemAccountService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/accounts")
public class SystemAccountController {

    @Autowired
    private SystemAccountService service;

    // Open for registration
    @PostMapping("/add")
    public SystemAccountDTO addAccount(@RequestBody SystemAccountDTO dto) {
        return service.addAccount(dto);
    }

    @PreAuthorize("hasRole('AGENCY_MANAGER')")
    @GetMapping("/all")
    public List<SystemAccountDTO> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PreAuthorize("hasRole('AGENCY_MANAGER') or #id == principal.id")
    @GetMapping("/{id}")
    public SystemAccountDTO getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PreAuthorize("hasRole('AGENCY_MANAGER') or #id == principal.id")
    @PutMapping("/update/{id}")
    public SystemAccountDTO updateAccount(@PathVariable Long id, @RequestBody SystemAccountDTO dto) {
        return service.updateAccount(id, dto);
    }

    @PreAuthorize("hasRole('AGENCY_MANAGER')")
    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        return service.deleteAccount(id);
    }
}