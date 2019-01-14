package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.service.impl.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result post(@RequestBody BookDto bookDto) {
        return Result.ok(bookService.save(bookDto));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result get(@PathVariable Long id) {
        try {
            return Result.ok(bookService.find(id));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getAll() {
        return Result.ok(bookService.getAll());
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto put(@RequestBody BookDto dto) {
        return bookService.update(dto);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean delete(@PathVariable Long id) {
        return bookService.remove(id);
    }

}