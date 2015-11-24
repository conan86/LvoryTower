package com.tusk.lvoryTower.module;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	private long userId;
	private String username;
	private String password;
	private int birthday;
	private String idNumber;
	private String idCardPhotoPath;
	private String realName;
	private int shoolId;
	private int departmentId;
	private String photoPath;
	private Date registerDate;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdCardPhotoPath() {
		return idCardPhotoPath;
	}

	public void setIdCardPhotoPath(String idCardPhotoPath) {
		this.idCardPhotoPath = idCardPhotoPath;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getShoolId() {
		return shoolId;
	}

	public void setShoolId(int shoolId) {
		this.shoolId = shoolId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
