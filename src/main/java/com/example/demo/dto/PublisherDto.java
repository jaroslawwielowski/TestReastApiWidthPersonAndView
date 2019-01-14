package com.example.demo.dto;


import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class PublisherDto {

    private Long id;
    @NotEmpty
    private String name;
    private List<BookDto> books;

    public PublisherDto() {
    }

    public PublisherDto(Long id, String name, List<BookDto> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

}

