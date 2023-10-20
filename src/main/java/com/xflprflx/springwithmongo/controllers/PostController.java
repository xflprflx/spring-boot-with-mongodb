package com.xflprflx.springwithmongo.controllers;

import com.xflprflx.springwithmongo.dtos.PostDTO;
import com.xflprflx.springwithmongo.dtos.PostDTO;
import com.xflprflx.springwithmongo.models.Post;
import com.xflprflx.springwithmongo.services.PostService;
import com.xflprflx.springwithmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{postId}")
    private ResponseEntity<PostDTO> findById(@PathVariable String postId){
        PostDTO postDTO = postService.findById(postId);
        return ResponseEntity.ok().body(postDTO);
    }
}
