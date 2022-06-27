package com.bookrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookrental.custom.exception.BusinessException;
import com.bookrental.custom.exception.ControllerException;
import com.bookrental.model.Category;
import com.bookrental.service.CategoryService;

@RestController
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//Add Category
	@PostMapping("/category")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		try {
			return ResponseEntity.ok(this.categoryService.addCategory(category));
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("636", "Something went wrong in Controller layer " + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Get All Category
	@GetMapping("/category")
	public ResponseEntity<?> getAllCategory() {
		try {
			return ResponseEntity.ok(this.categoryService.getAllCategory());
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("639", "Something went wrong in Controller layer " + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
	}
	
	//Get Specific Category
	// /category/id
//	@GetMapping("/category/{id}")
//	public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {
//		try {
//			return ResponseEntity.ok(this.categoryService.getCategory(id));
//		}catch(BusinessException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}catch(Exception e) {
//			ControllerException ce = new ControllerException("637", "Something went wrong in Controller layer " + e.getMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}
//		
//	}
	
	//Update Category using category id
//	@PutMapping("/category/{id}")
//	public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
//		try {
//			return ResponseEntity.ok(this.categoryService.updateCategory(category, id));
//		}catch(BusinessException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}catch(Exception e) {
//			ControllerException ce = new ControllerException("638", "Something went wrong in Controller layer " + e.getMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}
//		
//	}
	
	//Delete Category
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		this.categoryService.deleteCategory(id);
	}
}
