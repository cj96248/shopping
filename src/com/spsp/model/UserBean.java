package com.spsp.model;

import java.sql.Timestamp;

public class UserBean {
	private String id;
	private String name;
	private int age;
	private String status;
	private Timestamp rdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + ", rdate=" + rdate
				+ "]";
	}

}
