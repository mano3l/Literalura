package com.personal.Literalura.repository;

import com.personal.Literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID>{
}
