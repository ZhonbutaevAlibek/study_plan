package com.example.demo.services;

import com.example.demo.entities.GenreEntity;
import com.example.demo.exceptions.GenreAlreadyExistException;
import com.example.demo.exceptions.GenreNotFoundException;
import com.example.demo.DTO.GenreDTO;
import com.example.demo.repositories.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private GenreRepo genreRepo;

    public GenreEntity addGenre(GenreEntity genre) throws GenreAlreadyExistException {
        if(genreRepo.findByGenre(genre.getGenre()) != null){
            throw new GenreAlreadyExistException("This genre already exists !");
        }
        return genreRepo.save(genre);
    }


    public GenreDTO getOne(Long id) throws GenreNotFoundException {
        GenreEntity genre = genreRepo.findById(id).get();
        if(genre == null){
            throw new GenreNotFoundException("This Genre not fount :(");
        }
        return GenreDTO.toModel(genre);
    }


    public String delete(Long id){
        GenreEntity genre = genreRepo.findById(id).get();
        genreRepo.deleteById(id);
        return genre.getGenre() + " has been deleted from genres";
    }


    public GenreDTO update(Long id, GenreEntity editedGenre) throws GenreNotFoundException {
        GenreEntity genre = genreRepo.findById(id).get();
        if(genre == null){
            throw new GenreNotFoundException("This Genre not found :(");
        }
        genre.setGenre(editedGenre.getGenre());
        genreRepo.save(genre);

        return GenreDTO.toModel(genre);
    }
}
