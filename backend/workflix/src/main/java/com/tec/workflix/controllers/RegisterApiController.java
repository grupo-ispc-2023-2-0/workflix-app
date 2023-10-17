package com.tec.workflix.controllers;

import com.tec.workflix.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterApiController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterApiController.class);

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
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // REGISTER NEW USER
        int result = userService.registerNewUserServiceMethod(first_name, last_name, email, hashed_password);

        if (result !=1){
            return new ResponseEntity<>("FALLO AL INTENTAR REGISTRARSE",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("USUARIO REGISTRADO CORRECTAMENTE",HttpStatus.OK);
    }
}
