package com.example.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.example.travel.dto.LoginDTO;
import com.example.travel.dto.AuthResponseDTO;
import com.example.travel.security.JwtUtil;
import com.example.travel.entity.SystemAccount;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO dto) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
        final String token = jwtUtil.generateToken(userDetails);
        
        SystemAccount account = (SystemAccount) userDetails;
        
        return ResponseEntity.ok(new AuthResponseDTO(token, account.getRole().name(), account.getId()));
    }
}