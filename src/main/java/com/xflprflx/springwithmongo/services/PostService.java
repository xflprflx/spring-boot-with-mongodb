package com.xflprflx.springwithmongo.services;

import com.xflprflx.springwithmongo.dtos.PostDTO;
import com.xflprflx.springwithmongo.models.Post;
import com.xflprflx.springwithmongo.repositories.PostRepository;
import com.xflprflx.springwithmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        Post post = obj.orElseThrow(() -> new ResourceNotFoundException("Post not found."));
        return new PostDTO(post, post.getComents());
    }

    public List<PostDTO> findByTitle(String text){
        List<Post> postList = postRepository.findByTitleContainingIgnoreCase(text);
        List<PostDTO> posts = postList.stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
        return posts;
    }
}
