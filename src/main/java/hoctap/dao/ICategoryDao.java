package hoctap.dao;

import java.util.List;

import hoctap.models.CategoryModel;

public interface ICategoryDao {
	
	List<CategoryModel> findAll();
	
	CategoryModel findByID(int id);
	List<CategoryModel> findByName(String name);
	
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	void updateStatus(int id, int status);
}
