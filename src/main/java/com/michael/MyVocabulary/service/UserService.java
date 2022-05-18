package com.michael.MyVocabulary.service;

import com.michael.MyVocabulary.entity.User;
import com.michael.MyVocabulary.model.UserModel;
import com.michael.MyVocabulary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User registeredUser){
        registeredUser.setPassword(passwordEncoder.encode(registeredUser.getPassword()));

        userRepository.save(registeredUser);
        return registeredUser;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
