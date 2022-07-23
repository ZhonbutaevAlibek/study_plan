package com.example.demo.services;

import com.example.demo.entities.GenreEntity;
import com.example.demo.entities.PostEntity;
import com.example.demo.exceptions.GenreNotFoundException;
import com.example.demo.exceptions.PostAlreadyExistException;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.models.Post;
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

    public Post getOne(Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("This post not found :(");
        }
        return Post.toModel(post);
    }

    public String deletePost(Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("This post not found :(");
        }
        postRepo.deleteById(id);
        return "\"" + post.getPost() + "\" has been deleted";
    }

    public Post update(Long id, PostEntity editedPost) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if(post == null){
            throw new PostNotFoundException("This post not found :(");
        }
        post.setPost(editedPost.getPost());
        postRepo.save(post);

        return Post.toModel(post);
    }
}
