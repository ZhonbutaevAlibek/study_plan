package com.example.demo.controllers;

import com.example.demo.entities.GenreEntity;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.exceptions.GenreAlreadyExistException;
import com.example.demo.exceptions.GenreNotFoundException;
import com.example.demo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity addGenre(@RequestBody GenreEntity genre){
        try{
            genreService.addGenre(genre);
            return ResponseEntity.ok("New Genre has been added :)");
        } catch(GenreAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }

    @GetMapping
    public ResponseEntity getOneGenre(@RequestParam Long id){
        try{
            return ResponseEntity.ok(genreService.getOne(id));
        } catch(GenreNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenre(@PathVariable Long id){
        try{
            return ResponseEntity.ok(genreService.delete(id));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity updateGenre(@PathVariable Long id, @RequestBody GenreEntity genre){
        try{
            return ResponseEntity.ok(genreService.update(id, genre));
        } catch(GenreNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error! WTF is this ?!");
        }
    }
}
