package com.xflprflx.springwithmongo.config;

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

        User luke = new User(null, "Luke", "luke@gmail.com");
        User yoda = new User(null, "Yoda", "yoda@gmail.com");
        User anakin = new User(null, "Anakin", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Bye", "May stackoverflow be with you.", luke);
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Do!", "Do. Or do not. There is no try.", yoda);

        userRepository.saveAll(Arrays.asList(luke, yoda, anakin));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
