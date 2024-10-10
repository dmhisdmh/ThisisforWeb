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
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("images"), rs.getString("phone"),
						rs.getInt("roleid"), rs.getDate("createDate")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {

		// Not need.
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreateDate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreateDate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
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
		String sql = "INSERT INTO users(username, password, email, roleid, createDate) VALUES (?, ?, ?, ?, ?)";

		try {
			conn = super.getDatabaseConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, 3); // RoleId User const
			ps.setDate(5, user.getCreateDate());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // Trả về true nếu tồn tại, false nếu không
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistEmail(String mail) {
		String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mail);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // Trả về true nếu tồn tại, false nếu không
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();

		// userDao.insert(new UserModel(6, "123","123","abc@gmail.com","ABCDE", "", "",
		// 2,new Date(System.currentTimeMillis())));
//		userDao.insert(new UserModel("dog", "god", "dog@gmai.com", new Date(System.currentTimeMillis())));
//		List<UserModel> list = userDao.findAll();
//		for (UserModel user : list) {
		System.out.println(userDao.checkExistEmail("dmh@gmail.com"));
		// }

	}

	@Override
	public void update(UserModel user) {
		// Update information, bug

		String sql = "INSERT INTO users(id, username, password, email, fullname, images, phone, roleid, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = super.getDatabaseConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getImages());
			ps.setString(7, user.getPhone());
			ps.setInt(8, user.getRoleid());
			ps.setDate(9, user.getCreateDate());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean update(String email, String newPassword) {
		String sql = "UPDATE users SET password = ? WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, newPassword); // Đặt mật khẩu mới
			ps.setString(2, email); // Đặt email

			int rowUpdates = ps.executeUpdate();
			return rowUpdates > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
