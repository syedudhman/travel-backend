package com.example.travel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travel.entity.SystemAccount;

@Repository
public interface SystemAccountRepository extends JpaRepository<SystemAccount, Long> {

    Optional<SystemAccount> findByEmail(String email);

    boolean existsByEmail(String email);

}