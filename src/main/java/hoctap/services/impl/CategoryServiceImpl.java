package hoctap.services.impl;

import java.util.List;

import hoctap.dao.ICategoryDao;
import hoctap.dao.impl.CategoryDaoImpl;
import hoctap.models.CategoryModel;
import hoctap.models.UserModel;
import hoctap.services.ICategoryService;


public class CategoryServiceImpl implements ICategoryService{
	
	ICategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findByID(int id) {
		return categoryDao.findByID(id);
	}

	@Override
	public List<CategoryModel> findByName(String name) {
		return categoryDao.findByName(name);
	}

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findByID(category.getCategoryid());
		if (cate != null)
			categoryDao.update(category);
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findByID(id);
		if (cate != null)
			categoryDao.delete(id);
	}

	@Override
	public void updateStatus(int id, int status) {
		// TODO Auto-generated method stub
	}
	
	
	}

