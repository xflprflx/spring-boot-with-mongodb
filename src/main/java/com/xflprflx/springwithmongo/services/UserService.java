package com.xflprflx.springwithmongo.services;

import com.xflprflx.springwithmongo.models.User;
import com.xflprflx.springwithmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
