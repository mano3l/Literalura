package com.personal.Literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "title")
    private String title;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
    @Column(name = "language")
    private String language;
    @Column(name = "download_count")
    private String downloadCount;

    public Book() {
    }

    public Book(String bookId, String title, List<Author> authors, String language, String downloadCount) {
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(String downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + bookId +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", language='" + language + '\'' +
                ", downloadCount='" + downloadCount + '\'' +
                '}';
    }
}
