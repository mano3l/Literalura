package com.personal.Literalura.repository;

import com.personal.Literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID>{
}
