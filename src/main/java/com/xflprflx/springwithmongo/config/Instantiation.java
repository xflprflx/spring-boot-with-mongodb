package com.xflprflx.springwithmongo.config;

import com.xflprflx.springwithmongo.dtos.AuthorDTO;
import com.xflprflx.springwithmongo.dtos.ComentDTO;
import com.xflprflx.springwithmongo.models.Post;
import com.xflprflx.springwithmongo.models.User;
import com.xflprflx.springwithmongo.repositories.PostRepository;
import com.xflprflx.springwithmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User yoda = new User(null, "Yoda", "yoda@gmail.com");
        User luke = new User(null, "Luke", "luke@gmail.com");
        User anakin = new User(null, "Anakin", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(luke, yoda, anakin));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Good bye", "May stackoverflow be with you.", new AuthorDTO(yoda));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Do!", "Do. Or do not. There is no try.", new AuthorDTO(yoda));

        ComentDTO c1 = new ComentDTO("Thank you!", sdf.parse("21/03/2018"), new AuthorDTO(luke));
        ComentDTO c2 = new ComentDTO("Thank you master!", sdf.parse("21/03/2018"), new AuthorDTO(anakin));
        ComentDTO c3 = new ComentDTO("You're crazy!", sdf.parse("21/03/2018"), new AuthorDTO(luke));
        post1.getComents().addAll(Arrays.asList(c1, c2));
        post2.getComents().addAll(Arrays.asList(c3));
        postRepository.saveAll(Arrays.asList(post1, post2));

        yoda.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(yoda);
    }
}
