package com.bookrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookrental.custom.exception.BusinessException;
import com.bookrental.custom.exception.ControllerException;
import com.bookrental.model.Book;
import com.bookrental.service.BookService;

@RestController
public class BookController {

	@Autowired 
	private BookService bookService;
	
	//Add Book
	@PostMapping("/book")
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		try {
			return ResponseEntity.ok( this.bookService.addBook(book));
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("671", "Something went wrong on controller layer " +e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Get All Books
	@GetMapping("/book")
	public ResponseEntity<?> getAllBook() {
		try {
			return ResponseEntity.ok(this.bookService.getAllBook());
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("672", "Something went wrong on controller layer " +e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Get specific Book using id
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBook(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(this.bookService.getBook(id));
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("673", "Something went wrong on controller layer " +e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
	}
	
	//Update specific book using id
	@PutMapping("/book/{id}")
	public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(this.bookService.updateBook(book, id));
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("674", "Something went wrong on controller layer " +e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete Specific Book using ID
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		this.bookService.deleteBook(id);
	}
}
