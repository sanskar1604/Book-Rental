package com.bookrental.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookrental.custom.exception.BusinessException;
import com.bookrental.model.Language;
import com.bookrental.repo.LanguageRepo;
import com.bookrental.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepo languageRepo;
	
	
	//Add Language
	@Override
	public Language addLanguage(Language language) {
		if(language.getLanguage().isEmpty() || language.getLanguage().length() == 0) {
			throw new BusinessException("601", "Please enter proper language, It is blank");
		}
		try {
			return this.languageRepo.save(language);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("602", "Given language is null");
		}catch(Exception e) {
			throw new BusinessException("603", "Something went wrong in service layer " + e.getMessage());
		}
		
	}

	
	//Get All Language
	@Override
	public List<Language> getAllLanguage() {
		try {
			List<Language> lang = this.languageRepo.findAll();
			if(lang.isEmpty()) {
				throw new BusinessException("604", "List is completely empty, we have nothing to return");
			}
			return lang;
		}catch(Exception e) {
			throw new BusinessException("605", "Something went wrong in service layer " + e.getMessage());
		}
	}


	//Get Specific Language Using id
//	@Override
//	public Language getLanguage(Long id) {
//		try {
//			return this.languageRepo.findById(id).get();
//		}catch(IllegalArgumentException e) {
//			throw new BusinessException("606", "Given language id is null");
//		}catch(java.util.NoSuchElementException e) {
//			throw new BusinessException("607", "Given language id does not exist in database");
//		}catch(Exception e) {
//			throw new BusinessException("608", "Something went wrong in service layer " + e.getMessage());
//		}
//		
//	}

	//Update specific Language using id
//	@Override
//	public Language updateLanguage(Long id, Language language) {
//		if(language.getLanguage().isEmpty() || language.getLanguage().length() == 0) {
//			throw new BusinessException("609", "Please enter proper language, It is blank");
//		}
//		try {
//			Language lang = this.languageRepo.findById(id).get();
//			lang.setLanguage(language.getLanguage());
//			return this.languageRepo.save(lang);
//		}catch(IllegalArgumentException e) {
//			throw new BusinessException("610", "Given language is null");
//		}catch(java.util.NoSuchElementException e) {
//			throw new BusinessException("615", "Given language id does not exist in database");
//		}catch(Exception e) {
//			throw new BusinessException("611", "Something went wrong in service layer " + e.getMessage());
//		}
//	}


	//Delete specific Language using id
	@Override
	public void deleteLanguage(Long id) {
		try {
//			Language lang = new Language();
//			lang.setLangId(id);
//			this.languageRepo.delete(lang);
		this.languageRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("612", "Given language id is null");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("613", "Given language id does not exist in database");
		}catch(Exception e) {
			throw new BusinessException("614", "Something went wrong in service layer " + e.getMessage());
		}
	}
	
	

}
