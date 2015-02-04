package com.tieto.titan.spring.jdbcTemplate.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.Range;

public class UserInfo {
	private int id;
	
	@NotEmpty(message = "Please enter your username")
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alpanumeric with no spaces" ) 
	private String username;
	
	@NotEmpty(message = "Please enter your password")
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long")
	private String password;
	
	//@Range(min = 1, max = 150,message="Age must more then 1 and lower then 150")
	private int age;
	
	private String photoPath;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
}
