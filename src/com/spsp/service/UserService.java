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
			System.out.println(pstmt.toString());
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
	
	public List<UserBean> getUserByName(String name){
		Connection conn = DBConnection.getConnection();
		List<UserBean> list = new ArrayList<UserBean>();
		String sql = "select * from user where user.name LIKE ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			System.out.println(pstmt.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
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
	
	public void deleteUserById(String id){
		Connection conn = DBConnection.getConnection();
		String sql = "delete form user where user.id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			System.out.println(stmt.toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(UserBean u){
		Connection conn = DBConnection.getConnection();
		String sql = "update user set name=?, age=?,rdate=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getName());
			pstmt.setInt(2, u.getAge());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(4, u.getId());
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void frozenUserById(String id){
		Connection conn = DBConnection.getConnection();
		String sql = "update user set user.status='D' where id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			System.out.println(stmt.toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<UserBean> getUsers(){
		List<UserBean> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user order by rdate desc ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt.toString());
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
	
	public List<UserBean> getUsers(int start, int count){
		List<UserBean> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user order by rdate desc LIMIT ?,?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, count);
			System.out.println(pstmt.toString());
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
	
	public List<UserBean> getForzenUsers(){
		List<UserBean> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user where user.status = 'D'";
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
