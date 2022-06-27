package com.bookrental.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookrental.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
