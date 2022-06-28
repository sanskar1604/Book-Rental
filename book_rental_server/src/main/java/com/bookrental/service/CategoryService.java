package com.bookrental.service;

import java.util.List;

import com.bookrental.model.Category;

public interface CategoryService {

	//Add Category
	public Category addCategory(Category category);
	//Get All Category
	public List<Category> getAllCategory();
	//Get Specific Category
	public Category getCategory(Long id);
	//Update Category
	public Category updateCategory(Category category, Long id);
	//Delete Specific Category
	public void deleteCategory(Long id);
}
