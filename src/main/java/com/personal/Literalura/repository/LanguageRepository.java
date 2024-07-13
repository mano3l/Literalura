package com.personal.Literalura.repository;

import com.personal.Literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
    Language findByLanguage(String language);
}
