package org.thwick.moneytracker.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thwick.moneytracker.dao.CategoryDAO;
import org.thwick.moneytracker.models.Category;

@Service
public class CategoryService {

	@Inject
	private CategoryDAO categoryDAO;
	
	public CategoryService()
	{
		
	}
	
	@Transactional
	public Category newCategory(Category category) {
		return categoryDAO.create(category);
	}
	
	@Transactional
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	@Transactional
	public void delete(List<Long> categoryIds) {
		categoryDAO.delete(categoryIds);
	}
	
	@Transactional
	public void delete(Long categoryId) {
		categoryDAO.delete(categoryId);
	}
}
