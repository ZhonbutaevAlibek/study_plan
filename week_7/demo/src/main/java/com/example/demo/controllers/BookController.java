package com.example.demo.controllers;

import com.example.demo.entities.BookEntity;
import com.example.demo.exceptions.BookAlreadyExistException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity addBook(@RequestBody BookEntity book,
                                  @RequestParam Long authorId,
                                  @RequestParam Long genreId){
        try{
            bookService.addBook(book, authorId, genreId);
            return ResponseEntity.ok("New Book has been added :)");
        } catch (BookAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error!!!");
        }
    }

    @GetMapping
    public ResponseEntity getOneBook(@RequestParam Long id){
        try{
            return ResponseEntity.ok(bookService.getOne(id));
        } catch (BookNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!!!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneBook(@PathVariable Long id){
        try{
            return ResponseEntity.ok(bookService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error!!!");
        }
    }
}
