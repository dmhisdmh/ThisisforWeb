package hoctap.dao;

import java.util.List;

import hoctap.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();

	UserModel findById(int id);
	UserModel findByName(String username);
	UserModel findByEmail(String email);

	void insert(UserModel user);  //register
	void update(UserModel user);
	
	boolean update(String email, String newPassword); // ForgotPassword
	boolean checkExistUsername(String username);
	boolean checkExistEmail(String mail);
}
