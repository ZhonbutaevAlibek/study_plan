package com.example.demo.services;

import com.example.demo.entities.AuthorEntity;
import com.example.demo.entities.BookEntity;
import com.example.demo.entities.GenreEntity;
import com.example.demo.exceptions.BookAlreadyExistException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.models.Book;
import com.example.demo.repositories.AuthorRepo;
import com.example.demo.repositories.BookRepo;
import com.example.demo.repositories.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private GenreRepo genreRepo;

    public BookEntity addBook(BookEntity book, Long authorId, Long genreId) throws BookAlreadyExistException {
        if(bookRepo.findByTitle(book.getTitle()) != null){
            throw new BookAlreadyExistException("This Book already exist!");
        }

        AuthorEntity author = authorRepo.findById(authorId).get();
        GenreEntity genre = genreRepo.findById(genreId).get();
        book.setAuthor(author);
        book.setGenre(genre);

        return bookRepo.save(book);
    }

    public Book getOne(Long id) throws BookNotFoundException {
        BookEntity book = bookRepo.findById(id).get();
        if(book == null){
            throw new BookNotFoundException("This Book not found :(");
        }
        return Book.toModel(book);
    }

    public String delete(Long id){
        BookEntity book = bookRepo.findById(id).get();
        bookRepo.deleteById(id);
        return book.getTitle() + " has been deleted";
    }
}
