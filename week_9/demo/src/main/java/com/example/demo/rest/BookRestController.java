package com.example.demo.rest;

import com.example.demo.entities.BookEntity;
import com.example.demo.exceptions.BookAlreadyExistException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity addBook(@RequestBody BookEntity book,
                                  @RequestParam Long authorId,
                                  @RequestParam Long genreId){
        try{
            return ResponseEntity.ok(bookService.addBook(book, authorId, genreId));
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

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookEntity book,
                                         @RequestParam Long book_id,
                                         @RequestParam Long author_id,
                                         @RequestParam Long genre_id){
        try{
            return ResponseEntity.ok(bookService.update(book, book_id, author_id, genre_id));
        }catch(BookNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @GetMapping("/all")
    public Iterable<BookEntity> getAllBooks() {
        return bookService.getAll();
    }
}
