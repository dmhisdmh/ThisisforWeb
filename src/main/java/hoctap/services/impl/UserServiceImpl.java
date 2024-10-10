package hoctap.services.impl;

import java.sql.Date;

import hoctap.dao.IUserDao;
import hoctap.dao.impl.UserDaoImpl;
import hoctap.models.UserModel;
import hoctap.services.IUserService;

public class UserServiceImpl implements IUserService {

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
	public boolean register(String email, String username, String password) {
		if (checkExistEmail(email) || checkExistUsername(username)) {
			return false;
		}
		userDao.insert(new UserModel(username, password, email, new Date(System.currentTimeMillis())));
		return true;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByName(username);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean resetPassword(String email, String newPassword) {
		return userDao.update(email, newPassword);
		
	}

}
