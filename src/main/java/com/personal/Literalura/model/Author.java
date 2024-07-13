package com.personal.Literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    private final UUID authorId = UUID.randomUUID();
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_year")
    private String birthYear;
    @Column(name = "death_year")
    private String deathYear;
    @ManyToMany
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String birthYear, String deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", deathYear='" + deathYear + '\'' +
                '}';
    }
}
