package com.tec.workflix.controllers;

import com.tec.workflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterApiController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity registerNewUser(@RequestParam("first_name") String first_name,
                                          @RequestParam("last_name") String last_name,
                                          @RequestParam("email") String email,
                                          @RequestParam("password") String password){
        if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty()){
            return new ResponseEntity<>("Porfavor completa todas las celdas", HttpStatus.BAD_REQUEST);
        }
        // ENCRIPTACION / HASH PASSWORD

    }
}
