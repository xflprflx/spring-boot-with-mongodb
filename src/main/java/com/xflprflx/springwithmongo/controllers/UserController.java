package com.xflprflx.springwithmongo.controllers;

import com.xflprflx.springwithmongo.dtos.PostDTO;
import com.xflprflx.springwithmongo.dtos.UserDTO;
import com.xflprflx.springwithmongo.models.Post;
import com.xflprflx.springwithmongo.models.User;
import com.xflprflx.springwithmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> listUserDTO = userService.findAll();
        return ResponseEntity.ok().body(listUserDTO);
    }

    @GetMapping(value = "/{userId}")
    private ResponseEntity<UserDTO> findById(@PathVariable String userId){
        UserDTO userDTO = userService.findById(userId);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userService.insert(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> update(@PathVariable String userId, @RequestBody UserDTO userDTO){
        userDTO = userService.update(userId, userDTO);
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping(value = "/{userId}")
    private ResponseEntity<Void> delete(@PathVariable String userId){
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{userId}/posts")
    private ResponseEntity<List<PostDTO>> findPosts(@PathVariable String userId){
        UserDTO userDTO = userService.findByIdWithPostDTO(userId);
        return ResponseEntity.ok().body(userDTO.getPosts());
    }
}
