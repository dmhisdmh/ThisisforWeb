package hoctap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hoctap.configs.DBConnectMySQL;
import hoctap.dao.ICategoryDao;
import hoctap.models.CategoryModel;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM categories";
		try {
			
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		while (rs.next()) {
//			list.add(new CategoryModel(rs.getInt("categoryid"), rs.getString("categoryname"), rs.getString("images"), rs.getInt("status")));
			CategoryModel category = new CategoryModel();
			category.setCategoryid(rs.getInt("categoryid"));
			category.setCategoryname(rs.getString("categoryname"));
			category.setImages(rs.getString("images"));
			category.setStatus(rs.getInt("status"));
			categories.add(category);
		}} catch (Exception e) {
		e.printStackTrace();}
		return categories;
	}

	@Override
	public CategoryModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO categories(categoryname, images, status) VALUES (?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();

			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE categories SET categoryname = ?, images = ?, status = ? WHERE categoryid = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();

			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		String sql = "UPDATE categories SET status = ? WHERE categoryid = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();

			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
