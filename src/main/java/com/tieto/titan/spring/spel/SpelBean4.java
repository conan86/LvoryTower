package com.tieto.titan.spring.spel;

public class SpelBean4 {

	private boolean validEmail;
	private City chosenCity;
	private City chosenCity2;
	private City chosenCity3;
	private String dbUsername;
	private String homePath;
	private String userDirPath;
	
	public boolean isValidEmail() {
		return validEmail;
	}
	public void setValidEmail(boolean validEmail) {
		this.validEmail = validEmail;
	}
	public City getChosenCity() {
		return chosenCity;
	}
	public void setChosenCity(City chosenCity) {
		this.chosenCity = chosenCity;
	}
	public City getChosenCity2() {
		return chosenCity2;
	}
	public void setChosenCity2(City chosenCity2) {
		this.chosenCity2 = chosenCity2;
	}
	public City getChosenCity3() {
		return chosenCity3;
	}
	public void setChosenCity3(City chosenCity3) {
		this.chosenCity3 = chosenCity3;
	}
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	public String getHomePath() {
		return homePath;
	}
	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}
	public String getUserDirPath() {
		return userDirPath;
	}
	public void setUserDirPath(String userDirPath) {
		this.userDirPath = userDirPath;
	}
	
}
