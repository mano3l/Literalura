package com.personal.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.personal.Literalura.model.Author;
import com.personal.Literalura.model.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {

    private static final Logger log = LoggerFactory.getLogger(BookDTO.class);
    @JsonAlias("id")
    private String bookId;
    @JsonAlias("title")
    private String title;
    @JsonAlias("authors")
    private List<AuthorsDTO> authors;
    @JsonAlias("languages")
    private List<String> languages;
    @JsonAlias("download_count")
    private Long downloadCount;

    public BookDTO() {
    }

    public BookDTO(String bookId, String title, List<AuthorsDTO> authors, List<String> languages, Long downloadCount) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }

    public List<Author> mapToAuthor() {
        List<Author> authors = null;
        if (this.authors != null) {
            authors = this.authors.stream()
                    .map(a -> new Author(a.getName(), a.getBirthYear(), a.getDeathYear()))
                    .toList();
        }
        return authors;
    }

    public List<Language> mapToLanguage() {
        List<Language> languages = null;
        if (this.languages != null) {
            languages = this.languages.stream()
                    .map(Language::new)
                    .toList();
        }
        return languages;
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

    public List<AuthorsDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorsDTO> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "BookApiDTO{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", language=" + languages +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
