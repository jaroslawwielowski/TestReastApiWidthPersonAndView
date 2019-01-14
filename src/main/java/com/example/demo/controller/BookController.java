package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.service.impl.BookService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
        public Result post(@RequestBody BookDto bookDto){
            return Result.ok(bookService.save(bookDto));
        }
    }

    @GetMapping(path = "/{id}",produces = APPLICATION_JSON_VALUE)
    public Result get(@PathVariable Long id){
        return Result.ok(personService.find(id));
    }
}
