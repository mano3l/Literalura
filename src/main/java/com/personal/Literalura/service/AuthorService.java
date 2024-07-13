package com.personal.Literalura.service;

import com.personal.Literalura.model.Author;
import com.personal.Literalura.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> listAuthors() {
        return this.authorRepository.findAll();
    }

    public List<Author> listAuthorsAliveIn(int year) {
        List<Author> authorsAlive = new ArrayList<>();
        this.authorRepository.findAll().forEach(author -> {
            if (year > Integer.parseInt(author.getBirthYear()) &&
                    (year < Integer.parseInt(author.getDeathYear()) ||
                            author.getDeathYear().isBlank() ||
                            author.getDeathYear() == null)) {
                authorsAlive.add(author);
            }
        });
        return authorsAlive;
    }
}
