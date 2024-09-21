package hoctap.services;

import hoctap.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);
}
