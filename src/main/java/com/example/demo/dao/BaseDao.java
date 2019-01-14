package com.example.demo.dao;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDao<E, I extends Serializable> {

    E save(E entity);

    E update(E entity);

    E find(I id);

    void delete(E entity);

    Collection<E> findAll();
}
