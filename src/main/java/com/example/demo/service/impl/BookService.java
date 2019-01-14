package com.example.demo.service.impl;

import com.example.demo.dao.impl.AuthorDao;
import com.example.demo.dao.impl.BookDao;
import com.example.demo.dao.impl.PublisherDao;
import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Publisher;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class BookService implements BaseService<BookDto, Long> {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
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
        Book book = bookDao.update(updateEntity(dto));
        return book.toDto();
    }

    @Override
    public BookDto find(Long id) {
        return bookDao.find(id).toDto();
    }

    @Override
    public Boolean remove(Long id) {
        Book book = bookDao.find(id);
        bookDao.delete(book);
        return true;
    }

    @Override
    public Collection<BookDto> getAll() {
        return bookDao.findAll().stream().filter(Objects::nonNull).map(Book::toDto).collect(Collectors.toList());
    }

    private Book updateEntity(BookDto dto) {
        Book book = bookDao.find(dto.getId());
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setRating(dto.getRating());
        addRelations(dto, book);
        return book;
    }

    private void addRelations(BookDto dto, Book book) {
        if (Objects.nonNull(dto.getAuthor()) && !dto.getAuthor().isEmpty()) {
            book.getAuthors().clear();
            for (AuthorDto auth : dto.getAuthor()) {
                Author author = authorDao.find(auth.getId());
                if (Objects.nonNull(author)) {
                    book.getAuthors().add(author);
                }
            }
        }

        if (Objects.nonNull(dto.getPublisherDto())) {
            Publisher publisher = publisherDao.find(dto.getPublisherDto().getId());
            if (Objects.nonNull(publisher)) {
                book.setPublisher(publisher);
            }
        }
    }
}
