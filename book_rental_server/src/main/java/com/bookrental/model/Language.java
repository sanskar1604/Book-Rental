package com.bookrental.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "language")
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lang_id")
	private Long langId;
	@Column(name = "language")
	private String language;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="language")
	@JsonIgnore
	private List<Book> book;
	//Default Constructor
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor
	public Language(Long langId, String language) {
		super();
		this.langId = langId;
		this.language = language;
	}
	
	//Getter and Setter Methods
	public Long getLangId() {
		return langId;
	}
	public void setLangId(Long langId) {
		this.langId = langId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
	
}
