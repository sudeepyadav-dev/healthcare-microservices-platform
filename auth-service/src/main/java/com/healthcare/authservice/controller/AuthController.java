package com.healthcare.authservice.controller;

import com.healthcare.authservice.apiResponse.APIResponse;
import com.healthcare.authservice.dto.LoginDto;
import com.healthcare.authservice.dto.UserDto;
import com.healthcare.authservice.service.AuthService;
import com.healthcare.authservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private LoginService loginService;

    //http://localhost:8080/api/v1/auth/register
    @PostMapping("/register")
    public ResponseEntity<APIResponse<String>> registerUser(@RequestBody UserDto dto) {
        APIResponse<String> response = authService.register(dto);
        return new ResponseEntity<> (response, HttpStatusCode.valueOf(response.getStatus()));
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> loginCheck(@RequestBody LoginDto logindto){
        return loginService.loginCheck(logindto);
    }


}

