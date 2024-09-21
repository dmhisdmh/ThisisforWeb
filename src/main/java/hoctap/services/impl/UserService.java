package hoctap.services.impl;

import hoctap.dao.IUserDao;
import hoctap.dao.impl.UserDaoImpl;
import hoctap.models.UserModel;
import hoctap.services.IUserService;

public class UserService implements IUserService {

	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;

	}

	@Override
	public UserModel FindByUserName(String username) {
		
		return userDao.findByName(username);
	}

}
