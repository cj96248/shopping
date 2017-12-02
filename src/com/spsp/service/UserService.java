package com.spsp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.spsp.model.UserBean;
import com.spsp.util.DBConnection;

public class UserService {

	public void save(UserBean user){
		Connection conn = DBConnection.getConnection();
		String sql = "insert into user values (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setInt(3, user.getAge());
			pstmt.setString(4, "A");
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public UserBean getUserById(String id){
		Connection conn = DBConnection.getConnection();
		UserBean user = new UserBean();
		String sql = "select * from user where user.id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setStatus(rs.getString("status"));
				user.setRdate(rs.getTimestamp("rdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public UserBean getUserByName(String name){
		Connection conn = DBConnection.getConnection();
		UserBean user = new UserBean();
		String sql = "select * from user where user.id LIKE ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setStatus(rs.getString("status"));
				user.setRdate(rs.getTimestamp("rdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<UserBean> getUsers(){
		List<UserBean> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				UserBean user = new UserBean();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setStatus(rs.getString("status"));
				user.setRdate(rs.getTimestamp("rdate"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	} 
}
