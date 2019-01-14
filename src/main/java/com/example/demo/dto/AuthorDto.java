package com.example.demo.dto;


import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public class AuthorDto {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private List<BookDto> books;
    private LocalDate yearOfBirth;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String firstName, List<BookDto> books) {
        this.id = id;
        this.firstName = firstName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
