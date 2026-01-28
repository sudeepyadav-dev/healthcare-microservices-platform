package com.healthcare.authservice.service;

import com.healthcare.authservice.apiResponse.APIResponse;
import com.healthcare.authservice.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> loginCheck(@RequestBody LoginDto loginDto) {
        APIResponse<String> response = new APIResponse<>();

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        try {
            Authentication authenticate = authManager.authenticate(token);
            if (authenticate.isAuthenticated()) {
                String jwtToken = jwtService.generateToken(loginDto.getEmail(),
                        authenticate.getAuthorities().iterator().next().getAuthority());

                response.setMessage("Login Successful");
                response.setStatus(200);
                response.setData(jwtToken);  // return JWT
                return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setMessage("Failed");
        response.setStatus(401);
        response.setData("Unauthorized");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }
}
