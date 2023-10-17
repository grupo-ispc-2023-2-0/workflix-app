package com.tec.workflix.controllers;

import com.tec.workflix.models.Login;
import com.tec.workflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginApiController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity authenticateUser(@RequestBody Login login){

        // Get user email:
        List<String> userEmail = userService.checkUserEmail(login.getEmail());

        // Check IF email is Empty
        if(userEmail.isEmpty() || userEmail == null){
            return new ResponseEntity("El correo no existe", HttpStatus.NOT_FOUND);
        }
        // End of check if emails is empty


        return new ResponseEntity();
    }
}
