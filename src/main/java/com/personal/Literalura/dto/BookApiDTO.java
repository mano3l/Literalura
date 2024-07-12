package com.personal.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookApiDTO {
    @JsonAlias("id")
    private String bookId;
    @JsonAlias("title")
    private String title;
    @JsonAlias("authors")
    private List<AuthorApiDTO> authors;
    @JsonAlias("languages")
    private List<String> language;
    @JsonAlias("download_count")
    private BigInteger downloadCount;

    public BookApiDTO(String bookId, String title, List<AuthorApiDTO> authors, List<String> language, BigInteger downloadCount) {
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

    public List<AuthorApiDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorApiDTO> authors) {
        this.authors = authors;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public BigInteger getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(BigInteger downloadCount) {
        this.downloadCount = downloadCount;
    }
}
