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
import com.bookrental.model.Language;
import com.bookrental.service.LanguageService;

@RestController
@CrossOrigin("*")
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	//Add language
	@PostMapping("/language")
	public ResponseEntity<?> addLanguage(@RequestBody Language language) {
		try {
			return ResponseEntity.ok(this.languageService.addLanguage(language));
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("616", "Something went wrong in Controller layer " + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
	}
	
	//Get All Language
	@GetMapping("/language")
	public ResponseEntity<?> getAllLanguage() {
		try {
			return ResponseEntity.ok(this.languageService.getAllLanguage());
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("617", "Something went wrong in Controller layer " + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Get Specific Language Using id
//	@GetMapping("/language/{id}")
//	public ResponseEntity<?> getLanguage(@PathVariable("id") Long id) {
//		try {
//			return ResponseEntity.ok(this.languageService.getLanguage(id));
//		}catch(BusinessException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}catch(Exception e) {
//			ControllerException ce = new ControllerException("618", "Something went wrong at controller layer " + e.getMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}
//		
//	}
	
	//Update specific Language using id
//	@PutMapping("/language/{id}")
//	public ResponseEntity<?> updateLanguage(@PathVariable("id") Long id, @RequestBody Language language) {
//		try {
//			return ResponseEntity.ok(this.languageService.updateLanguage(id, language));
//		}catch(BusinessException e) {
//			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}catch(Exception e) {
//			ControllerException ce = new ControllerException("619", "Something went wrong at controller layer " + e.getMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
//		}
//		
//	}
	
	//delete specific Language using id
	@DeleteMapping("/language/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		this.languageService.deleteLanguage(id);

	}
}
