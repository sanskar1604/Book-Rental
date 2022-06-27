package com.bookrental.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookrental.custom.exception.BusinessException;
import com.bookrental.model.Book;
import com.bookrental.repo.BookRepo;
import com.bookrental.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	//Add Book
	@Override
	public Book addBook(Book book) {
		if(book.getBookAuthor().isEmpty() || book.getBookAuthor().length() == 0) {
			throw new BusinessException("640", "Please enter proper book author, It is blank");
		}else if(book.getBookTitle().isEmpty() || book.getBookTitle().length() == 0) {
			throw new BusinessException("641", "Please enter proper book title, It is blank");
		}else if(book.getBookBinding().isEmpty() || book.getBookBinding().length() == 0) {
			throw new BusinessException("642", "Please enter proper book binding, It is blank");
		}else if(book.getBookDesc().isEmpty() || book.getBookDesc().length() == 0) {
			throw new BusinessException("643", "Please enter proper book description, It is blank");
		}else if(book.getBookEdition().isEmpty() || book.getBookEdition().length() == 0) {
			throw new BusinessException("644", "Please enter proper book edition, It is blank");
		}else if(book.getBookPublisher().isEmpty() || book.getBookPublisher().length() == 0) {
			throw new BusinessException("646", "Please enter proper book publisher, It is blank");
		}
		try {
			return this.bookRepo.save(book);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("649", "Given book is null");
		}catch(Exception e) {
			throw new BusinessException("650", "Some thing went wrong in service layer " + e.getMessage());
		}
		
	}

	//Get All Books
	@Override
	public List<Book> getAllBook() {
		try {
			List<Book> books = this.bookRepo.findAll();
			if(books.isEmpty()) {
				throw new BusinessException("651", "List is completely empty, we have nothing to return");
			}
			return books;
		}catch(Exception e) {
			throw new BusinessException("652", "Some thing went wrong in service layer " + e.getMessage());
		}
		
	}

	//Get specific Book using id
	@Override
	public Book getBook(Long id) {
		try {
			return this.bookRepo.findById(id).get();
		}catch(IllegalArgumentException e) {
			throw new BusinessException("653", "Given book id is null");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("654", "Given book id does not exist in database");
		}catch(Exception e) {
			throw new BusinessException("655", "Something went wrong in service layer " + e.getMessage());
		}
		
	}

	//Update Specific Book using id
	@Override
	public Book updateBook(Book book, Long id) {
		if(book.getBookAuthor().isEmpty() || book.getBookAuthor().length() == 0) {
			throw new BusinessException("656", "Please enter proper book author, It is blank");
		}else if(book.getBookTitle().isEmpty() || book.getBookTitle().length() == 0) {
			throw new BusinessException("657", "Please enter proper book title, It is blank");
		}else if(book.getBookBinding().isEmpty() || book.getBookBinding().length() == 0) {
			throw new BusinessException("658", "Please enter proper book binding, It is blank");
		}else if(book.getBookDesc().isEmpty() || book.getBookDesc().length() == 0) {
			throw new BusinessException("659", "Please enter proper book description, It is blank");
		}else if(book.getBookEdition().isEmpty() || book.getBookEdition().length() == 0) {
			throw new BusinessException("660", "Please enter proper book edition, It is blank");
		}else if(book.getBookPublisher().isEmpty() || book.getBookPublisher().length() == 0) {
			throw new BusinessException("662", "Please enter proper book publisher, It is blank");
		}
		try {
			Book books = this.bookRepo.findById(id).get();
			books.setBookAuthor(book.getBookAuthor());
			books.setBookBinding(book.getBookBinding());
			books.setBookDesc(book.getBookDesc());
			books.setBookEdition(book.getBookEdition());
			books.setBookImg(book.getBookImg());
			books.setBookPages(book.getBookPages());
			books.setBookPrice(book.getBookPrice());
			books.setBookPublisher(book.getBookPublisher());
			books.setBookTitle(book.getBookTitle());
			books.setCategory(book.getCategory());
			books.setLanguage(book.getLanguage());
			return this.bookRepo.save(books);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("665", "Given book is null");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("666", "Given book id does not exist in database");
		}catch(Exception e) {
			throw new BusinessException("667", "Something went wrong in service layer " + e.getMessage());
		}
		
	}

	//Delete Specific Book Using ID
	public void deleteBook(Long id) {
		try {
			Book book = new Book();
			book.setBookId(id);
			this.bookRepo.delete(book);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("668", "Given book is null");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("669", "Given book id does not exist in database");
		}catch(Exception e) {
			throw new BusinessException("670", "Something went wrong in service layer " + e.getMessage());
		}
		
	}
}
