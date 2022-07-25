package com.example.demo.services;

import com.example.demo.entities.PostEntity;
import com.example.demo.exceptions.PostAlreadyExistException;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.DTO.PostDTO;
import com.example.demo.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public PostEntity addPost(PostEntity post) throws PostAlreadyExistException {
        if(postRepo.findByPost(post.getPost()) != null){
            throw new PostAlreadyExistException("This post already exist!");
        }
        return postRepo.save(post);
    }

    public PostDTO getOne(Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("This post not found :(");
        }
        return PostDTO.toModel(post);
    }

    public String deletePost(Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("This post not found :(");
        }
        postRepo.deleteById(id);
        return "\"" + post.getPost() + "\" has been deleted";
    }

    public PostDTO update(Long id, PostEntity editedPost) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("This post not found :(");
        }
        post.setPost(editedPost.getPost());
        postRepo.save(post);

        return PostDTO.toModel(post);
    }
}
