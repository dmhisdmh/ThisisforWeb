package hoctap.services.impl;

import java.util.List;

import hoctap.dao.ICategoryDao;
import hoctap.dao.impl.CategoryDaoImpl;
import hoctap.models.CategoryModel;
import hoctap.services.ICategoryService;


public class CategoryServiceImpl implements ICategoryService{
	

	ICategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
