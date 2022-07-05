package com.cts.authorizationmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorizationmodule.model.AuthResponse;
import com.cts.authorizationmodule.model.UserModel;
import com.cts.authorizationmodule.service.JwtUtil;
import com.cts.authorizationmodule.service.MyUserDetailsService;

@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserModel userlogincredentials) {
		final UserDetails userdetails = userDetailsService.loadUserByUsername(userlogincredentials.getId());
		String uid = "";
		String generateToken = "";
		if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
			uid = userlogincredentials.getId();
			generateToken = jwtutil.generateToken(userdetails);
			System.out.println("Jwt" + generateToken);
			return new ResponseEntity<>(new UserModel(uid, null, null, generateToken), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {

		AuthResponse res = new AuthResponse();
		if (token == null) {
			res.setValid(false);

			return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
		} else {
//			System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
//			System.out.println(token);
			if (token.contains("Bearer")) {
				token = token.substring(7);
			}
			if (jwtutil.validateToken(token)) {
				res.setId(jwtutil.extractUsername(token));
				res.setValid(true);
				res.setName("Agent");
			} else {
				res.setValid(false);
				return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);

			}
		}
		return new ResponseEntity<>(res, HttpStatus.OK);

	}
}
