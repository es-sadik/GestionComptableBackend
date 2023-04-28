package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.security.jwtclasses.JwtRequest;
import com.example.cabinetcomptable.security.jwtclasses.JwtResponse;
import com.example.cabinetcomptable.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
