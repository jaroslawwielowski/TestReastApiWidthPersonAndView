package com.example.demo.controller;

import com.example.demo.dto.PublisherDto;
import com.example.demo.service.impl.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Result post(@RequestBody PublisherDto publisherDto) {
        return Result.ok(publisherService.save(publisherDto));
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result get(@PathVariable Long id) {
        return Result.ok(publisherService.find(id));
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result put(@RequestBody PublisherDto publisherDto) {
        return Result.ok(publisherService.update(publisherDto));
    }

    @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
    public Result getAll() {
        return Result.ok(publisherService.getAll());
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Result delete(@PathVariable Long id) {
        return Result.ok(publisherService.remove(id));
    }

}