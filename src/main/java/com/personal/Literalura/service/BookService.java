package com.personal.Literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.Literalura.api.ApiRequests;
import com.personal.Literalura.dto.ResultsDTO;
import com.personal.Literalura.model.Author;
import com.personal.Literalura.model.Book;
import com.personal.Literalura.model.Language;
import com.personal.Literalura.repository.AuthorRepository;
import com.personal.Literalura.repository.BookRepository;
import com.personal.Literalura.repository.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;
    private final LanguageRepository languageRepository;

    public BookService(BookRepository bookRepository, LanguageRepository languageRepository) {
        this.bookRepository = bookRepository;
        this.languageRepository = languageRepository;
    }

    public Book getBookByName(String name) {
        ApiRequests request = new ApiRequests();
        String res = request.getBookByName(name);

        Book book = new Book();
        try {
            ResultsDTO results = new ObjectMapper()
                    .readerFor(ResultsDTO.class)
                    .readValue(res);

            results.getResults().forEach(b -> {
                book.setBookId(b.getBookId());
                book.setTitle(b.getTitle());
                book.setAuthors(b.mapToAuthor());
                book.setLanguage(b.mapToLanguage());
                book.setDownloadCount(b.getDownloadCount());

                book.setAuthorId(book.getAuthors().getFirst().getAuthorId());
                book.setLanguageId(book.getLanguage().getFirst().getLanguageId());

                book.getAuthors().getFirst().setBookId(book.getBookId());
                book.getLanguage().getFirst().setBookId(book.getBookId());
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            this.bookRepository.saveAndFlush(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return book;
    }

    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }

    public List<Book> listBooksByLanguage(String language) {
        Language language1 = this.languageRepository.findByLanguage(language);
        return this.bookRepository.findByLanguage(language1);
    }
}
