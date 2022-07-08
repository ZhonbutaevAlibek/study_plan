package com.example.demo.controllers;

import com.example.demo.entities.GenreEntity;
import com.example.demo.entities.PostEntity;
import com.example.demo.exceptions.GenreNotFoundException;
import com.example.demo.exceptions.PostAlreadyExistException;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity addPost(@RequestBody PostEntity post){
        try{
            postService.addPost(post);
            return ResponseEntity.ok("New post has been added :)");
        } catch (PostAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOnePost(@RequestParam Long id){
        try{
            return ResponseEntity.ok(postService.getOne(id));
        } catch (PostNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id){
        try{
            return ResponseEntity.ok(postService.deletePost(id));
        } catch (PostNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable Long id, @RequestBody PostEntity post){
        try{
            return ResponseEntity.ok(postService.update(id, post));
        } catch(PostNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }
}
