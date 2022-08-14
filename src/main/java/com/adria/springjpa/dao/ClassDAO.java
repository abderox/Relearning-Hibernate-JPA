package com.adria.springjpa.dao;


import java.util.List;

public interface ClassDAO<T, ID> {
    T save(T cp);

    List<T> findAll();

    T findByCode(ID code);

    T update(T cp);

    void delete(ID id);
}
