package com.harmony.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harmony.gw.dto.AccountCredentials;
import com.harmony.gw.dto.UserRegisterDTO;
import com.harmony.gw.entity.Employee;
import com.harmony.gw.service.JwtService;
import com.harmony.gw.service.UserServiceImpl;

@RestController
public class AuthController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> getTokent(@RequestBody AccountCredentials credentls) {

		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentls.getEmpNo(),
				credentls.getPassword());

		Authentication auth = authenticationManager.authenticate(creds);

		String jwts = jwtService.getToken(auth.getName());

		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization").build();
	}
	
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO user) {
        Employee savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
