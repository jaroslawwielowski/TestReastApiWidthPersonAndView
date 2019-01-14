package com.example.demo.converter;

import com.example.demo.dto.AuthorDto;
import com.example.demo.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

class AuthorConverter implements Converter<String, AuthorDto> {

    @Autowired
    private AuthorService authorService;

    @Override
    public AuthorDto convert(String source) {
        return this.authorService.find(Long.valueOf(source));
    }
}