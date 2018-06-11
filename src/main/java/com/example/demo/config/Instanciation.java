package com.example.demo.config;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.AutorDTO;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * Created by Fernanda on 11/06/2018.
 */

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... strings) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria", "maria@gmail.com");
        User fernanda = new User(null, "Fernanda", "fernandalarissahtp@gmail.com");
        User douglas = new User(null, "Douglas", "douglas@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, fernanda, douglas));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Primeiro Post", "Teste de postagem", new AutorDTO(fernanda));
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Teste Post", "Teste de postagem 2", new AutorDTO(douglas));


        postRepository.saveAll(Arrays.asList(post1, post2));

        fernanda.getPosts().addAll(Arrays.asList(post1));
        douglas.getPosts().addAll(Arrays.asList(post2));

        userRepository.saveAll(Arrays.asList(fernanda, douglas));

    }
}
