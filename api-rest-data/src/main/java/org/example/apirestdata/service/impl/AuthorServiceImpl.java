package org.example.apirestdata.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.apirestdata.entity.Author;
import org.example.apirestdata.repository.AuthorRepository;
import org.example.apirestdata.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(Long aLong) {
        return authorRepository.findById(aLong)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
    }

   @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

   @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

   @Override
    public Author update(Long id, Author entity) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author not found"));
        author.setName(entity.getName());
        author.setEmail(entity.getEmail());
        return authorRepository.save(author);

    }

    @Override
    public void deleteById(Long aLong) {
     Author author = authorRepository.findById(aLong).orElseThrow(() -> new EntityNotFoundException("Author not found"));
     authorRepository.delete(author);
    }


    @Override
    public List<Author> getAuthorsWithOutBooks() {
        return authorRepository.findAuthorsWithoutBooks();
    }
}
