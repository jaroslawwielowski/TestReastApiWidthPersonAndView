package com.example.demo.service;

import java.io.Serializable;
import java.util.Collection;

public interface BaseService<D, I extends Serializable> {

    D save(D dto);

    D update(D dto);

    D find(I id);

    Boolean remove(I id);

    Collection<D> getAll();
}
