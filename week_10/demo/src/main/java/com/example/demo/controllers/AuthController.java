package com.example.demo.controllers;

import com.example.demo.DTO.AuthUserDTO;
import com.example.demo.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity generateToken(@RequestBody AuthUserDTO authUserDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authUserDTO.getUsername(), authUserDTO.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }

        String token = jwtProvider.generateToken(authUserDTO.getUsername());
        Map<Object, Object> result = new HashMap<>();
        result.put("username", authUserDTO.getUsername());
        result.put("token", token);

        return ResponseEntity.ok(result);
    }
}
