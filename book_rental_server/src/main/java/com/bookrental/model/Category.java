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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private Long catId;
	@Column(name = "cat_title")
	private String catTitle;
	@Column(name = "cat_description")
	private String catDescription;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="category")
	@JsonIgnore
	private List<Book> book;
	//Default Constructor
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public Category(Long catId, String catTitle, String catDescription) {
		super();
		this.catId = catId;
		this.catTitle = catTitle;
		this.catDescription = catDescription;
	}
	
	//Getter and Setter Methods
	public Long getcatId() {
		return catId;
	}

	public void setcatId(Long catId) {
		this.catId = catId;
	}

	public String getcatTitle() {
		return catTitle;
	}

	public void setcatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

	public String getcatDescription() {
		return catDescription;
	}

	public void setcatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}	
	
	
}
