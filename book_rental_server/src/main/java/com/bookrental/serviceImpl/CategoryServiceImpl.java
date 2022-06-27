package com.bookrental.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookrental.custom.exception.BusinessException;
import com.bookrental.model.Category;
import com.bookrental.repo.CategoryRepo;
import com.bookrental.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	
	//Add Category
	@Override
	public Category addCategory(Category category) {
		if(category.getcatTitle().isEmpty() || category.getcatTitle().length() == 0) {
			throw new BusinessException("620", "Please enter proper category, It is blank");
		}else if(category.getcatDescription().isEmpty() || category.getcatDescription().length() == 0) {
			throw new BusinessException("621", "Please enter proper category description, It is blank");
		}
		try {
			return this.categoryRepo.save(category);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("622", "Given category is null");
		}catch(Exception e) {
			throw new BusinessException("623", "Something went wrong in service layer " + e.getMessage());
		}
		
	}

	
	//Get All Category
	@Override
	public List<Category> getAllCategory() {
		try {
			List<Category> cat = this.categoryRepo.findAll();
			if(cat.isEmpty()) {
				throw new BusinessException("624", "List is completely empty, we have nothing to return");
			}
			return cat;
		}catch(Exception e) {
			throw new BusinessException("625", "Something went wrong in Service layer " + e.getMessage());
		}
		
	}


	//Get Specific Category
//	@Override
//	public Category getCategory(Long id) {
//		// TODO Auto-generated method stub
//		try {
//			return this.categoryRepo.findById(id).get();
//		}catch(IllegalArgumentException e) {
//			throw new BusinessException("626", "Given category id is null");
//		}catch(java.util.NoSuchElementException e) {
//			throw new BusinessException("627", "Given category id does not exist in database");
//		}catch(Exception e) {
//			throw new BusinessException("628", "Something went wrong in service layer " + e.getMessage());
//		}
//		
//	}


	//Update Category
//	@Override
//	public Category updateCategory(Category category, Long id) {
//		if(category.getcatTitle().isEmpty() || category.getcatTitle().length() == 0) {
//			throw new BusinessException("629", "Please enter proper category, It is blank");
//		}else if(category.getcatDescription().isEmpty() || category.getcatDescription().length() == 0) {
//			throw new BusinessException("630", "Please enter proper category description, It is blank");
//		}
//		try {
//			Category cat = this.categoryRepo.findById(id).get();
//			cat.setcatTitle(category.getcatTitle());
//			cat.setcatDescription(category.getcatDescription());
//			return this.categoryRepo.save(cat);
//		}catch(IllegalArgumentException e) {
//			throw new BusinessException("631", "Given category is null");
//		}catch(java.util.NoSuchElementException e) {
//			throw new BusinessException("633", "Given category id does not exist in database");
//		}catch(Exception e) {
//			throw new BusinessException("632", "Something went wrong in service layer " + e.getMessage());
//		}
//		
//	}


	@Override
	public void deleteCategory(Long id) {
		try {
			Category cat = new Category();
			cat.setcatId(id);
			this.categoryRepo.delete(cat);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("633", "Given category id is null");
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("634", "Given category id does not exist in database");
		}catch(Exception e) {
			throw new BusinessException("635", "Something went wrong in service layer " + e.getMessage());
		}
		
	}

}
