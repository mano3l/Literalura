package com.personal.Literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    private final UUID authorId = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "birth_year")
    private String birthYear;
    @Column(name = "death_year")
    private String deathYear;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String birthYear, String deathYear, List<Book> books) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.books = books;
    }

    public UUID getAuthorId() {
        return authorId;
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
}
