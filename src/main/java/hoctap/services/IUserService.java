package hoctap.services;

import hoctap.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);

	UserModel FindByUserName(String username);

	boolean register(String email, String username, String password);
	boolean resetPassword(String email, String newPassword);

	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);

}
