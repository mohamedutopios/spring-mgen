package org.example.apirestdata.service;

import java.util.List;

public interface CrudService<T,ID> {

    T findById(ID id);

    List<T> findAll();

    T save(T t);

    void deleteById(ID id);

    T update(ID id,T t);


}