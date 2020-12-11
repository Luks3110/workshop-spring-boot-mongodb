package com.lucasfernandes.workshopmongo.services;

import com.lucasfernandes.workshopmongo.domain.Post;
import com.lucasfernandes.workshopmongo.repository.PostRepository;
import com.lucasfernandes.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Post post = repo.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }
}