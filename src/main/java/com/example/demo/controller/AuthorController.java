package com.example.demo.controller;

import com.example.demo.dto.AuthorDto;
import com.example.demo.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Result post(@RequestBody AuthorDto authorDto) {
        return Result.ok(authorService.save(authorDto));
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result get(@PathVariable Long id) {
        return Result.ok(authorService.find(id));
    }

    @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
    public Result getAll() {
        return Result.ok(authorService.getAll());
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result put(@RequestBody AuthorDto dto) {
        return Result.ok(authorService.update(dto));
    }

    @DeleteMapping(path = "/{id}")
    public Result delete(@PathVariable Long id) {
        return Result.ok(authorService.remove(id));
    }}
