package com.example.ProteinApp.service;

import java.util.List;
import com.example.ProteinApp.entities.User;

public interface IuserService {

    User saveUser(User user);

    List<User> findAllUsers();


}