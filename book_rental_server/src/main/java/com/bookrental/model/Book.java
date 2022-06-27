package com.bookrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private Long bookId;
	@Column(name="book__title")
	private String bookTitle;
	@Column(name="book_author")
	private String bookAuthor;
	@Column(name="book__edition")
	private String bookEdition;
	@Column(name="book_price")
	private Integer bookPrice;
	@Column(name="book_publisher")
	private String bookPublisher;
	@Column(name="book_desc")
	private String bookDesc;
	@Column(name="book_pages")
	private Integer bookPages;
	@Column(name="book_binding")
	private String bookBinding;
	@Column(name="book_img")
	private String bookImg;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cat_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="lang_id")
	private Language language;
	
	//Default Constructor
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public Book(Long bookId, String bookTitle, String bookAuthor, String bookEdition, Integer bookPrice,
			String bookPublisher, String bookDesc, Integer bookPages, String bookBinding, String bookImg) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookEdition = bookEdition;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
		this.bookDesc = bookDesc;
		this.bookPages = bookPages;
		this.bookBinding = bookBinding;
		this.bookImg = bookImg;
	}

	//Getter and Setter Methods
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public Integer getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public Integer getBookPages() {
		return bookPages;
	}

	public void setBookPages(Integer bookPages) {
		this.bookPages = bookPages;
	}

	public String getBookBinding() {
		return bookBinding;
	}

	public void setBookBinding(String bookBinding) {
		this.bookBinding = bookBinding;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
	
}
