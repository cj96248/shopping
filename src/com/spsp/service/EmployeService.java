package com.spsp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spsp.model.Employe;
import com.spsp.util.DBConnection;

public class EmployeService {
	
	public void save(Employe employe){
		Connection connection = DBConnection.getConnection();
		String sql = "insert into employe(id, name, age, idcard, status, year) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, employe.getId());
			ps.setString(2, employe.getName());
			ps.setInt(3, employe.getAge());
			ps.setString(4, employe.getIdcard());
			ps.setString(5, employe.getStatus());
			int year = 0;
			if(employe.getIdcard() != null){
				try {
					year = Integer.parseInt(employe.getIdcard().substring(6, 10));
				} catch (Exception e) {
				}
			}
			ps.setInt(6, year);
			System.out.println(ps.toString());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void idCard() {
		String idString = "";
		Pattern pattern = Pattern.compile("[0-9]{18}");
		Matcher matcher = pattern.matcher(idString);
		if(matcher.matches()){
			System.out.println("AA");
		}else {
			System.out.println("Not");
		}

	}
	public static void main(String[] args) {
		idCard();
	}
	
}
