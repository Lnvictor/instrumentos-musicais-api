package com.api.instrumentosmusicais.controllers;

import com.api.instrumentosmusicais.dto.TokenResponseDTO;
import com.api.instrumentosmusicais.dto.UserDTO;
import com.api.instrumentosmusicais.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200,https://resonant-taiyaki-7c6d17.netlify.app/")
public class AuthController {
    @Autowired
    private AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> doLogin(@RequestBody UserDTO dto){
        try{
            TokenResponseDTO tokenDTO = this.service.doLogin(dto.getUsername(), dto.getPassword());
            return ResponseEntity.ok(tokenDTO);
        }
        catch (Exception e){
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/sign-up")
    public UserDTO createUser(@RequestBody UserDTO dto){
        dto = this.service.doSignUp(dto.getUsername(), dto.getPassword());
        return dto;
    }
}
