package com.example.demo.entities;

import com.example.demo.dto.BookDto;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5)
    private String title;

    @Size(min = 1)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    @Size(max = 600)
    private String description;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer rating;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @NotNull
    @Min(1)
    private Integer pages;

    public Book() {
    }

    public Book(String title, String description, Integer rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Transient
    public BookDto toDto() {
        BookDto bookDto = new BookDto();
        bookDto.setId(getId());
        bookDto.setAuthor(Optional.ofNullable(this.getAuthors()).orElse(Collections.emptySet()).stream().map(Author::toCollectionlessDto).collect(Collectors.toList()));
        bookDto.setDescription(getDescription());

        if (Objects.nonNull(getPublisher())) {
            bookDto.setPublisherDto(getPublisher().toCollectionlessDto());
        }
        bookDto.setRating(getRating());
        bookDto.setTitle(getTitle());
        bookDto.setPages(getPages());
        return bookDto;
    }
}