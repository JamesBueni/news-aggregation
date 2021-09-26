package com.fracta.newsaggregation.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fracta.newsaggregation.dto.RegisterRequest;
import com.fracta.newsaggregation.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return new ResponseEntity<>("Account Activated!", HttpStatus.OK);
	}
	
	@GetMapping("/accountVerification/{tokenName}")
	public ResponseEntity<String> verifyUser(@PathVariable String tokenName) {
		authService.verifyUser(tokenName);
		return new ResponseEntity<>("Account Verified!", HttpStatus.OK);
	}
}
