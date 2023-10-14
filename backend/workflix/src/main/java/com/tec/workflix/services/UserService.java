package com.tec.workflix.services;

import com.tec.workflix.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public int registerNewUserServiceMethod(String fname, String lname, String email, String password){
        return userRepository.registerNewUser(fname,lname,email,password);
    }
}
