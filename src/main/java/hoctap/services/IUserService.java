package hoctap.services;

import hoctap.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);

	UserModel FindByUserName(String username);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);


}
