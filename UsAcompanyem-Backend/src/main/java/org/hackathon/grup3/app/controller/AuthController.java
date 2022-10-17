package org.hackathon.grup3.app.controller;

import org.hackathon.grup3.app.payload.request.LoginRequest;
import org.hackathon.grup3.app.payload.request.SignupRequest;
import org.hackathon.grup3.app.payload.response.JwtResponse;
import org.hackathon.grup3.app.payload.response.MessageResponse;
import org.hackathon.grup3.app.payload.response.MessageResponseWrapper;
import org.hackathon.grup3.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signin(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authenticateUser(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> signup(@Valid @RequestBody SignupRequest signupRequest) {
        MessageResponseWrapper responseWrapper = authService.registerUser(signupRequest);
        return new ResponseEntity<>(responseWrapper.getMessageResponse(), responseWrapper.getStatus());
    }
}
