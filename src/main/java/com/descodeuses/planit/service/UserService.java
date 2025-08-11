package com.descodeuses.planit.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.descodeuses.planit.dto.AuthRequest;
import com.descodeuses.planit.dto.AuthResponse;
import com.descodeuses.planit.dto.SignupRequestDTO;
import com.descodeuses.planit.dto.SignupResponseDTO;
import com.descodeuses.planit.entity.DCUSER;
import com.descodeuses.planit.repository.UserRepository;
import com.descodeuses.planit.security.JwtUtil;


@Service
public class UserService {
  
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

 
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // =========== LOGIN =========
    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(), 
                request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getUsername());
        return new AuthResponse(token);

    }

    // === SIGN-UP ===
    public SignupResponseDTO registerUser(SignupRequestDTO request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Utilisateur déjà existant !");
        }

        DCUSER user = new DCUSER();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setGenre(request.getGenre());
        user.setEmail(request.getEmail());

        DCUSER saved = userRepository.save(user);
        return mapToSignupResponseDTO(saved);
    }

      // === MAPPER pour sign-up ===
    private SignupResponseDTO mapToSignupResponseDTO(DCUSER user) {
        SignupResponseDTO dto = new SignupResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        dto.setNom(user.getNom());
        dto.setPrenom(user.getPrenom());
        dto.setGenre(user.getGenre());
        dto.setEmail(user.getEmail());
        return dto;
    }
    

}
