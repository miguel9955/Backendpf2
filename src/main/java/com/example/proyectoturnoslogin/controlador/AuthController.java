package com.example.proyectoturnoslogin.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoturnoslogin.Auth.AuthResponse;
import com.example.proyectoturnoslogin.Auth.AuthService;
import com.example.proyectoturnoslogin.Auth.LoginRequest;
import com.example.proyectoturnoslogin.Auth.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")

@RequiredArgsConstructor
public class AuthController {
	
	 private final AuthService authService;
	    
	    @PostMapping(value = "login")
	    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
	    {
	        return ResponseEntity.ok(authService.login(request));
	    }
	    
	    @PostMapping(value = "register")
	    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
	    {
	        return ResponseEntity.ok(authService.register(request));
	    }

}
