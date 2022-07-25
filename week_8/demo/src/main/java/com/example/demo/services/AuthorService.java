package com.example.demo.services;

import com.example.demo.entities.AuthorEntity;
import com.example.demo.exceptions.AuthorAlreadyExistException;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.DTO.AuthorDTO;
import com.example.demo.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public AuthorEntity addAuthor(AuthorEntity author) throws AuthorAlreadyExistException {
        if(authorRepo.findByName(author.getName()) != null){
            throw new AuthorAlreadyExistException("This Author already exists !");
        }
        return authorRepo.save(author);
    }

    public AuthorDTO getOne(Long id) throws AuthorNotFoundException {
        AuthorEntity author = authorRepo.findById(id).get();
        if(author == null){
            throw new AuthorNotFoundException("This Author not found :(");
        }
        return AuthorDTO.toModel(author);
    }

    public String delete(Long id){
        AuthorEntity author = authorRepo.findById(id).get();
        authorRepo.deleteById(id);
        return author.getName();
    }

    public AuthorDTO update(Long id, AuthorEntity editedAuthor) throws AuthorNotFoundException {
        AuthorEntity author = authorRepo.findById(id).get();
        if(author == null){
            throw new AuthorNotFoundException("This Author not found :(");
        }
        author.setName(editedAuthor.getName());
        authorRepo.save(author);

        return AuthorDTO.toModel(author);
    }
}
