package hoctap.services;

import java.util.List;

import hoctap.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);
	void delete(int id);
	void edit(CategoryModel category);
	
	List<CategoryModel> findAll();
	
}
