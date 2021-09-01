package com.getir.auth.controller;

import com.getir.auth.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Api(value = "Auth Api for service Authorization")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    @ApiOperation(value = "To get JWT Token")
    public ResponseEntity<String> login(@RequestBody String userName) {
        String token = jwtUtil.generateToken(userName);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Creates new account to get JWT Token")
    public ResponseEntity<String> register(@RequestBody String userName) {
        System.out.println("Info saved...");

        return new ResponseEntity<>("Registered", HttpStatus.OK);
    }
}
