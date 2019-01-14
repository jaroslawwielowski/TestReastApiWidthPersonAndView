package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.entities.Book;
import com.example.demo.service.BaseService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;

@Component
@Transactional
public class BookDao extends AbstractBaseDao<Book, Long> implements BaseDao<Book, Long> {
    @Override
    public Book find(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void delete(Book entity) {

    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT b from Book b", Book.class).getResultList();
    }
}
