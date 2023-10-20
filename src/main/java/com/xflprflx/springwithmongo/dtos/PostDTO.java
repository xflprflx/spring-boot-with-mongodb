package com.xflprflx.springwithmongo.dtos;

import com.xflprflx.springwithmongo.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO authorDTO;

    private List<ComentDTO> coments = new ArrayList<>();

    public PostDTO(Post post) {
        this.id = post.getId();
        this.date = post.getDate();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.authorDTO = post.getAuthor();
    }

    public PostDTO(Post post, List<ComentDTO> coments) {
        this.id = post.getId();
        this.date = post.getDate();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.authorDTO = post.getAuthor();
        coments.forEach(coment -> this.coments.add(coment));
    }
}
