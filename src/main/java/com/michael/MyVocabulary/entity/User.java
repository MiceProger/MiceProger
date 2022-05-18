package com.michael.MyVocabulary.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;

    @Column(length = 60)
    private String password;

    public boolean equals(User user){
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) return true;
        else return false;
    }

}
