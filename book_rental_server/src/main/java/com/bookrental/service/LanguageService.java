package com.bookrental.service;

import java.util.List;

import com.bookrental.model.Language;

public interface LanguageService {

	//Add Language
	public Language addLanguage(Language language);
	//Get All Language
	public List<Language> getAllLanguage();
	//Get Specific Language Using id
//	public Language getLanguage(Long id);
	//Update specific language using id
//	public Language updateLanguage(Long id, Language language);
	//Delete specific Language using id
	public void deleteLanguage(Long id);
}
