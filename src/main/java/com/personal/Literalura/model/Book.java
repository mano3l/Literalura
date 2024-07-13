package com.personal.Literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "author_id")
    private UUID authorId;
    @Column(name = "language_id")
    private UUID languageId;
    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Language> language;

    @Column(name = "download_count")
    private Long downloadCount;

    public Book() {
    }

    public Book(String bookId, String title, List<Author> authors, List<Language> language, Long downloadCount) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.language = language;
        this.downloadCount = downloadCount;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getLanguageId() {
        return languageId;
    }

    public void setLanguageId(UUID languageId) {
        this.languageId = languageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "------ LIVRO ------\n" +
                "Titulo: " + title + "\n" +
                "Autor: " + authors.getFirst().getName() + "\n" +
                "Idioma: " + language.getFirst().getLanguage() + "\n" +
                "Numero de downloads: " + downloadCount + "\n" +
                "-------------------\n";
    }
}
