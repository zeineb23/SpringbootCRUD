package com.example.ProteinApp.service;

import com.example.ProteinApp.entities.User;
import com.example.ProteinApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IuserServiceImpl implements IuserService{
    @Autowired
    private UserRepository userRep;

    @Override
    public User saveUser(User user) {
        return userRep.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRep.findAll();
    }
}
