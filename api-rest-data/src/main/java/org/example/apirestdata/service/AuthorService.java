package org.example.apirestdata.service;

import org.example.apirestdata.entity.Author;

import java.util.List;

public interface AuthorService extends CrudService<Author,Long> {

    List<Author> getAuthorsWithOutBooks();


}
