package com.tec.workflix.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApiController {
    @PostMapping("/user/login")
    public ResponseEntity authenticateUser(){
        return new ResponseEntity();
    }
}
