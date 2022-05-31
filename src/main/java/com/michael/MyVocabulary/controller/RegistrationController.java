package com.michael.MyVocabulary.controller;

import com.michael.MyVocabulary.entity.User;
import com.michael.MyVocabulary.excepion.PasswordIsIncorrectException;
import com.michael.MyVocabulary.excepion.UserAlreadyExistException;
import com.michael.MyVocabulary.excepion.UserDoesNotExistException;
import com.michael.MyVocabulary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RegistrationController  {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public String login(/*@RequestBody User logedUser*/){
        /* List<User> users = userService.getAllUsers();
        for (User user: users) {
            if (user.getUsername().equals(logedUser.getUsername())) {
                if (user.getPassword().equals(passwordEncoder.matches(logedUser.getPassword()))) {
                    return new ResponseEntity<>(HttpStatus.OK);
                }else{
                    return new ResponseEntity<RuntimeException> (new PasswordIsIncorrectException(), HttpStatus.NOT_FOUND);
                }
            }
        }
        return new ResponseEntity<RuntimeException> (new UserDoesNotExistException(), HttpStatus.NOT_FOUND);*/
        return "Success";
    }

    @RequestMapping("/signUp")
    public ResponseEntity<RuntimeException> signUp(@RequestBody User regUser){
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            for (User user : users) {
                if (regUser.getUsername().equals(user.getUsername())) {
                    return new ResponseEntity<RuntimeException>(new UserAlreadyExistException(), HttpStatus.BAD_REQUEST);
                }
            }
        }
        userService.registerUser(regUser);
        return new ResponseEntity<RuntimeException>(HttpStatus.OK);
    }

}
