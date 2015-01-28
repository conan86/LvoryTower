package com.tieto.titan.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;
import com.tieto.titan.spring.mvc.dao.RegisterDAO;

@Service("registerService")
public class RegisterService {
	
	@Inject
	@Named("registerDAO")
	private RegisterDAO dao;
	
	 public boolean validateTheFileType( MultipartFile photo) {
		 String originalFileName = photo.getOriginalFilename();
		 String[] arr = originalFileName.split("\\.");
		 String extensionName = arr[arr.length-1];
		 if(extensionName.equals("jpg")) {
			 return true;
		 } 
		 return false;
	 }
	 
	 
	 public String savePhoto(MultipartFile photo) {
		 Date date = new Date();
		 SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssS");
		 Random random = new Random();
		 String fileName = df.format(date)+random.nextInt(10000)+".jpg";
		 
		 String filePath =System.getProperty("user.dir") +File.separator+ "photos"+File.separator+fileName;
		 File file = new File(filePath);
		 try {
			FileUtils.writeByteArrayToFile(file, photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return fileName;
	 }
	 
	 public void saveUserInfo(UserInfo userInfo) {
		 dao.SaveUser(userInfo);
	 } 
	 
}
