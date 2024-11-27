package com.group2.To_Do_App.security.auth.authController;


import com.group2.To_Do_App.security.auth.authPayload.login.AuthorizationResponse;
import com.group2.To_Do_App.security.auth.authPayload.login.LoginRequest;
import com.group2.To_Do_App.security.auth.authPayload.register.AuthenticationResponse;
import com.group2.To_Do_App.security.auth.authPayload.register.RegisterRequest;
import com.group2.To_Do_App.security.auth.authService.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> register(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthorizationResponse> logout(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.logout(token));
    }

}
