package hoctap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hoctap.configs.DBConnectMySQL;
import hoctap.dao.IUserDao;
import hoctap.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {

		String sql = "select * from users";

		List<UserModel> list = new ArrayList<>();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), 
						rs.getString("username"), 
						rs.getString("password"),
						rs.getString("email"), 
						rs.getString("fullname"), 
						rs.getString("images"),
						rs.getString("phone"),
						rs.getInt("roleid"),
						rs.getDate("createDate")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id, username, email, password, images, fullname, phone, roleid, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = super.getDatabaseConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getFullname());
			ps.setInt(7, user.getRoleid());
			ps.setString(8, user.getPhone());
			ps.setDate(9, user.getCreateDate());
			
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public UserModel findByName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
//		
//		List<UserModel> list = userDao.findAll();
//		for (UserModel user: list) {
//			System.out.println(user);
//		}
//		
		UserModel user = userDao.findByName("dmh");
		System.out.println(user);
		
	}

}
