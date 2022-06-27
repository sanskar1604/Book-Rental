package com.bookrental.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookrental.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
