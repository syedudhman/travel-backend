package com.example.travel.mapper;

import com.example.travel.dto.SystemAccountDTO;
import com.example.travel.entity.SystemAccount;

public class SystemAccountMapper {


    public static SystemAccountDTO toDTO(SystemAccount account) {

        SystemAccountDTO dto = new SystemAccountDTO();

        dto.setId(account.getId());
        dto.setFullName(account.getFullName());
        dto.setEmail(account.getEmail());
        dto.setPassword(account.getPassword());
        dto.setRole(account.getRole());
        dto.setActive(account.isActive());

        return dto;
    }

    
    public static SystemAccount toEntity(SystemAccountDTO dto) {

        SystemAccount account = new SystemAccount();

        account.setId(dto.getId());
        account.setFullName(dto.getFullName());
        account.setEmail(dto.getEmail());
        account.setPassword(dto.getPassword());
        account.setRole(dto.getRole());
        account.setActive(dto.isActive());

        return account;
    }
}