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

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (checkExistEmail(email) || checkExistUsername(username)) {
	        return true;
		}
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		 UserModel user = userDao.findByEmail(email); 
		    return user != null;
	}

	
	public boolean checkExistUsername(String username) {
		UserModel user = userDao.findByName(username);
		return user != null;
	}

	

	

}
