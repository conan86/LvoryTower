package com.tieto.titan.spring.mvc.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("registerService")
public class RegisterService {
	
	 public boolean validateTheFileType( MultipartFile photo) {
		 String originalFileName = photo.getOriginalFilename();
		 String[] arr = originalFileName.split("\\.");
		 String extensionName = arr[arr.length-1];
		 if(extensionName.equals("jpg")) {
			 return true;
		 } 
		 return false;
	 }
	 
	 public void savePhoto(MultipartFile photo) {
		 String filePath =System.getProperty("user.dir") +File.separator+ "photos"+File.separator+System.currentTimeMillis()+".jpg";
		 System.out.println(filePath);
		 File file = new File(filePath);
		 try {
			FileUtils.writeByteArrayToFile(file, photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 

}
