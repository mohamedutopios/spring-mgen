package org.example.apirestdata.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.apirestdata.entity.Author;
import org.example.apirestdata.repository.AuthorRepository;
import org.example.apirestdata.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class CustomAuthorServiceImpl  {

    private final AuthorRepository authorRepository;

    public CustomAuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

   // @Override
    public Author findById(Long aLong) {
        return authorRepository.findById(aLong)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
    }

    //@Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

   // @Override
    public Author save(Author author) {
        author.setName("Custom " + author.getName());
        return authorRepository.save(author);
    }

   // @Override
    public Author update(Long id, Author entity) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author not found"));
        author.setName("Custom update " + entity.getName());
        author.setEmail(entity.getEmail());
        return authorRepository.save(author);

    }

   // @Override
    public void deleteById(Long aLong) {
        Author author = authorRepository.findById(aLong).orElseThrow(() -> new EntityNotFoundException("Author not found"));
        authorRepository.delete(author);
    }



}
