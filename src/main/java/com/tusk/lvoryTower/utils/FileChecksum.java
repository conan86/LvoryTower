package com.tusk.lvoryTower.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class FileChecksum {
	public static final int BUFFER_SIZE = 2*1024*1024;
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		long startTime = System.currentTimeMillis(); 
		String filePath = "D:\\DevelopmentResource\\phantomjs-2.0.0-windows\\Test.mp4";
		String fileMd5 = getFileMD5Checksum(filePath);
		System.out.println("md5  : " +fileMd5);
		String fileSha1 = getFileSHAChecksum(filePath);
		System.out.println("Sha1 : " + fileSha1);
		long endTime = System.currentTimeMillis(); 
		double totalSeconds = ((endTime - startTime)/1000d);
		System.out.println("total execute time : " + totalSeconds + "s");
		
	}
	
	public static String byteArrayToHex(byte[] bytes) {
		 StringBuilder sb = new StringBuilder();
		    for(int i=0; i< bytes.length ;i++)
		    {
		        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		    }
		   return sb.toString();
	}
	
	public static String getFileSHAChecksum(String filePath) throws NoSuchAlgorithmException, IOException{
	      FileInputStream fileInputStream = null;
	      DigestInputStream digestInputStream = null;
	      try
	      {
	         MessageDigest messageDigest =MessageDigest.getInstance("SHA1");
	         fileInputStream = new FileInputStream(filePath);
	         digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
	         byte[] buffer =new byte[BUFFER_SIZE];
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
	
	public static String getFileMD5Checksum(String inputFilePath) throws IOException, NoSuchAlgorithmException {
	      FileInputStream fileInputStream = null;
	      DigestInputStream digestInputStream = null;
	      try
	      {
	         MessageDigest messageDigest =MessageDigest.getInstance("MD5");
	         fileInputStream = new FileInputStream(inputFilePath);
	         digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
	         byte[] buffer =new byte[BUFFER_SIZE];
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
