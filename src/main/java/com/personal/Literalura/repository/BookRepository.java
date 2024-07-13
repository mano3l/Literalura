package com.personal.Literalura.repository;

import com.personal.Literalura.model.Book;
import com.personal.Literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByLanguage(Language language);
}
