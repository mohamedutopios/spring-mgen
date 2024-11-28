package org.example.apirestdata.controller;


import jakarta.validation.Valid;
import org.example.apirestdata.dto.BookCreateDTO;
import org.example.apirestdata.entity.Author;
import org.example.apirestdata.entity.Book;
import org.example.apirestdata.service.AuthorService;
import org.example.apirestdata.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookCreateDTO bookCreateDTO) {

        try {
            Author author = authorService.findById(bookCreateDTO.getAuthorId());
            Book book = new Book();
            book.setAuthor(author);
            book.setTitle(bookCreateDTO.getTitle());
            return ResponseEntity.ok(bookService.save(book));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }




}
