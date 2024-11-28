package org.example.apirestdata.service.impl;

import org.example.apirestdata.entity.Book;
import org.example.apirestdata.repository.BookRepository;
import org.example.apirestdata.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book findById(Long aLong) {
        return bookRepository
                .findById(aLong)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long aLong) {
    Book book =findById(aLong);
    bookRepository.delete(book);
    }

    @Override
    public Book update(Long aLong, Book book) {
        Book book1 = findById(aLong);
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        return bookRepository.save(book1);
    }
}
