package com.xflprflx.springwithmongo.controllers;

import com.xflprflx.springwithmongo.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User(1L, "Maria Silva", "maria@gmail.com");
        User user2 = new User(2L, "Alex", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(list);
    }
}
