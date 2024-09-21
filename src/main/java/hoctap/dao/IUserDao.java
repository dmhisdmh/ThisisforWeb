package hoctap.dao;

import java.util.List;

import hoctap.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	UserModel findByName(String username);
	
	void insert(UserModel user);
	
	
}
