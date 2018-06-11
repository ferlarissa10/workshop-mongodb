package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Fernanda on 09/06/2018.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Optional<Post> findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return Optional.ofNullable(post.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado")));
    }

    public List<Post> findByTitle(String text){
        //return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchByTitle(text);
    }



}
