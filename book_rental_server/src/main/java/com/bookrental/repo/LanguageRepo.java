package com.bookrental.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookrental.model.Language;

public interface LanguageRepo extends JpaRepository <Language, Long>{

}
