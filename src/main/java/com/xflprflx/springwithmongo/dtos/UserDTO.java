package com.xflprflx.springwithmongo.dtos;

import com.xflprflx.springwithmongo.models.Post;
import com.xflprflx.springwithmongo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private List<PostDTO> posts = new ArrayList<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserDTO(User user, List<Post> posts) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        posts.forEach(post -> this.posts.add(new PostDTO(post)));
    }
}
