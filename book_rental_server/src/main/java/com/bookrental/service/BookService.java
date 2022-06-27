package com.bookrental.service;

import java.util.List;

import com.bookrental.model.Book;

public interface BookService {

	//Add Book
	public Book addBook(Book book);
	
	//Get All Books 
	public List<Book> getAllBook();
	
	//Get specific Book using id
	public Book getBook(Long id);
	
	//Update specific book using id
	public Book updateBook(Book book, Long id);
	
	//Delete Specific Using ID
	public void deleteBook(Long id);
}
