package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.exceptions.BookAlreadyExistException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.models.Book;
import com.example.demo.repositories.AuthorRepo;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private GenreRepo genreRepo;

    public Book addBook(BookEntity book, Long authorId, Long genreId) throws BookAlreadyExistException {
        if(bookRepo.findByTitle(book.getTitle()) != null){
            throw new BookAlreadyExistException("This Book already exist!");
        }

        AuthorEntity author = authorRepo.findById(authorId).get();
        GenreEntity genre = genreRepo.findById(genreId).get();
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepo.save(book);

        return Book.toModel(book);
    }

    public Book getOne(Long id) throws BookNotFoundException {
        BookEntity book = bookRepo.findById(id).get();
        if(book == null){
            throw new BookNotFoundException("This Book not found :(");
        }
        return Book.toModel(book);
    }

    public Book delete(Long id){
        BookEntity book = bookRepo.findById(id).get();
        bookRepo.deleteById(id);

        return Book.toModel(book);
    }

    public Book update(BookEntity editedBook,
                                 Long book_id,
                                 Long author_id, Long genre_id) throws BookNotFoundException {

        BookEntity book = bookRepo.findById(book_id).get();
        AuthorEntity author = authorRepo.findById(author_id).get();
        GenreEntity genre = genreRepo.findById(genre_id).get();

        if(book == null){
            throw new BookNotFoundException("This book not found :(");
        }

        book.setTitle(editedBook.getTitle());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setYear(editedBook.getYear());
        book.setPrice(editedBook.getPrice());
        book.setAmount(editedBook.getAmount());
        bookRepo.save(book);

        return Book.toModel(book);
    }


    /*=========================================*/
    public Iterable<BookEntity> getAll(){
        return bookRepo.findAll();
    }
}
