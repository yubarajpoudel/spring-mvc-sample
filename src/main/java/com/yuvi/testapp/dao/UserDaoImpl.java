package com.yuvi.testapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DB;

public class UserDaoImpl implements UserDao {

	Connection conn = null;

	@Override
	public void createuser(String userName, String password) {
		if (conn != null) {
			String sql = "INSERT INTO login(name, password) VALUES (?, ?)";
			Connection conn = DB.getDbcon();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void initConnection() {
		conn = DB.getDbcon();

	}

	@Override
	public boolean isValiduser(String userName, String password) {
		try {
			String sql = "select * from login where name='" + userName + "' and password='" + password + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			boolean hasUser = rs.next();
			return hasUser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
