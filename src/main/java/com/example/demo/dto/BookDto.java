package com.example.demo.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BookDto {
    private Long id;

    @NotNull
    @Size(min = 5)
    private String title;

    @Size(min = 1)
    private List<AuthorDto> author;

    @Size(max = 600)
    private String description;

    @Min(1)
    @Max(10)
    private Integer rating;

    @NotNull
    private PublisherDto publisherDto;

    @Min(1)
    private Integer pages;

    public BookDto(Long id, String title, List<AuthorDto> author, String description, Integer rating,
                   PublisherDto publisherDto, Integer pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.rating = rating;
        this.publisherDto = publisherDto;
        this.pages = pages;
    }

    public List<AuthorDto> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorDto> author) {
        this.author = author;
    }

    public BookDto() {
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

    public PublisherDto getPublisherDto() {
        return publisherDto;
    }

    public void setPublisherDto(PublisherDto publisherDto) {
        this.publisherDto = publisherDto;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
