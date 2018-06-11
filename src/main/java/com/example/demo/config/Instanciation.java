package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by Fernanda on 11/06/2018.
 */

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria", "maria@gmail.com");
        User fernanda = new User(null, "Fernanda", "fernandalarissahtp@gmail.com");
        User douglas = new User(null, "Douglas", "douglas@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, fernanda, douglas));

    }
}
