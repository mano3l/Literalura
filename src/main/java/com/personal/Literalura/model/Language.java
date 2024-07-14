package com.personal.Literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    private UUID languageId = UUID.randomUUID();
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "language")
    private String language;
    @ManyToMany
    private List<Book> books;

    public Language() {
    }

    public Language(String language) {
        this.language = language;
    }

    public UUID getLanguageId() {
        return languageId;
    }

    public void setLanguageId(UUID languageId) {
        this.languageId = languageId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Language{" +
                "language='" + language + '\'' +
                '}';
    }
}
