package com.example.demo.controllers;


import com.example.demo.entities.AuthorEntity;
import com.example.demo.exceptions.AuthorAlreadyExistException;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity addAuthor(@RequestBody AuthorEntity author){
        try{
            authorService.addAuthor(author);
            return ResponseEntity.ok("New Author has been added :)");
        } catch(AuthorAlreadyExistException e){
          return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }


    @GetMapping()
    public ResponseEntity getOneAuthor(@RequestParam Long id){
        try{
            return ResponseEntity.ok(authorService.getOne(id));
        }catch(AuthorNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        try{
            return  ResponseEntity.ok(authorService.delete(id));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity author){
        try{
            return  ResponseEntity.ok(authorService.update(id, author));
        } catch(AuthorNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }
}
