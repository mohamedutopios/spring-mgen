package org.example.apirestdata.controller;

import jakarta.validation.Valid;
import org.example.apirestdata.entity.Author;
import org.example.apirestdata.repository.AuthorRepository;
import org.example.apirestdata.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{idAuthor}")
    public ResponseEntity<Author> getAuthorById(@PathVariable long idAuthor) {
        Author author = authorService.findById(idAuthor);
        if(author != null) {
            return ResponseEntity.status(200).body(author);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createAuthor(@Valid @RequestBody Author author, BindingResult bindingResult) {
        ResponseEntity<Object> errors = getObjectResponseEntity(bindingResult);
        if (errors != null) return errors;
        return ResponseEntity.status(201).body(authorService.save(author));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable Long id,@Valid @RequestBody Author author, BindingResult bindingResult){
        ResponseEntity<Object> errors = getObjectResponseEntity(bindingResult);
        if (errors != null) return errors;
        return ResponseEntity.ok(authorService.update(id,author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    private ResponseEntity<Object> getObjectResponseEntity(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }
        return null;
    }


}

