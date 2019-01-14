package com.example.demo.service.impl;

import com.example.demo.dao.impl.AuthorDao;
import com.example.demo.dao.impl.BookDao;
import com.example.demo.dao.impl.PublisherDao;
import com.example.demo.dto.BookDto;
import com.example.demo.entities.Book;
import com.example.demo.service.BaseService;

import java.util.Collection;

public class BookService implements BaseService<BookDto, Long> {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookService(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @Override
    public BookDto save(BookDto dto) {
        Book book = new Book(dto.getTitle(), dto.getDescription(), dto.getRating());
        addRelations(dto, book);
        book = bookDao.save(book);
        return book.toDto();
    }


    @Override
    public BookDto update(BookDto dto) {
        return null;
    }

    @Override
    public BookDto find(Long id) {
        return null;
    }

    @Override
    public Boolean remove(Long id) {
        return null;
    }

    @Override
    public Collection<BookDto> getAll() {
        return null;
    }



    private void addRelations(BookDto dto, Book book) {
    }
}
