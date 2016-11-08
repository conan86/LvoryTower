package com.tusk.lvoryTower.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class FileChecksum {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		long startTime = System.currentTimeMillis(); 
		String filePath = "";
		String fileMd5 = getFileMD5Checksum(filePath);
		System.out.println("md5  : " +fileMd5);
		String fileSha1 = getFileSHAChecksum(filePath);
		System.out.println("Sha1 : " + fileSha1);
		long endTime = System.currentTimeMillis(); 
		double totalSeconds = ((endTime - startTime)/1000d);
		System.out.println("total execute time : " + totalSeconds + "s");
		
	}
	
	//下面这个函数用于将字节数组换成成16进制的字符串
	//95796a6128424e5da9fe7c24ac3a4bca
	public static String byteArrayToHex(byte[] bytes) {
		 StringBuilder sb = new StringBuilder();
		    for(int i=0; i< bytes.length ;i++)
		    {
		        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		    }
		   return sb.toString();
	}
	
	public static String getFileSHAChecksum(String filePath) throws NoSuchAlgorithmException, IOException{
		int bufferSize = 256*1024*1024;
	      FileInputStream fileInputStream = null;
	      DigestInputStream digestInputStream = null;
	      try
	      {
	         MessageDigest messageDigest =MessageDigest.getInstance("SHA1");
	         fileInputStream = new FileInputStream(filePath);
	         digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
	         byte[] buffer =new byte[bufferSize];
	         while (digestInputStream.read(buffer) > 0);
	         messageDigest= digestInputStream.getMessageDigest();
	         byte[] resultByteArray = messageDigest.digest();
	         return byteArrayToHex(resultByteArray);
	      } finally {
	         try {
	            digestInputStream.close();
	         } catch (Exception e) {
	         }
	         try {
	            fileInputStream.close();
	         } catch (Exception e) {
	         }
	      }
	}
	
	
	public static String getFileMD5Checksum(String inputFile) throws IOException, NoSuchAlgorithmException {
	      int bufferSize = 256*1024*1024;
	      FileInputStream fileInputStream = null;
	      DigestInputStream digestInputStream = null;
	      try
	      {
	         MessageDigest messageDigest =MessageDigest.getInstance("MD5");
	         fileInputStream = new FileInputStream(inputFile);
	         digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
	         byte[] buffer =new byte[bufferSize];
	         while (digestInputStream.read(buffer) > 0);
	         messageDigest= digestInputStream.getMessageDigest();
	         byte[] resultByteArray = messageDigest.digest();
	         return byteArrayToHex(resultByteArray);
	      } finally {
	         try {
	            digestInputStream.close();
	         } catch (Exception e) {
	         }
	         try {
	            fileInputStream.close();
	         } catch (Exception e) {
	         }
	      }
	   }
	
}
