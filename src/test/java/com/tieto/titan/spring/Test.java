package com.tieto.titan.spring;

import java.io.File;
import java.net.URL;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url  =  ClassLoader.getSystemClassLoader().getResource("");
		System.out.println(url.toString());
		System.out.println(System.getProperty("user.dir"));
		System.out.println(Class.class.getClass().getResource("/").getPath());
		 String filePath =  System.getProperty("user.dir")+File.separator+System.currentTimeMillis()+".jpg";
		 System.out.println(filePath);
		 
		 String originalFileName = "tianxiawushuang.mp3";
		 String extensionName = originalFileName.substring(originalFileName.indexOf(".") +1,originalFileName.length());
		 System.out.println(extensionName);
		 System.out.println(originalFileName.split(".").length);
		 
		 String[] arr = originalFileName.split("\\."); 
		 String extensionName2 = arr[arr.length-1];
		 System.out.println(extensionName2);
		 
		 String testStr = "123.234";
		 System.out.println(testStr.split("\\.").length);
	}
}
