package com.tusk.lvoryTower.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
public class EncryptUtil {  
    private static final String SITE_WIDE_SECRET = "my-secret-key-lvory-tower";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);
   
    public static String encrypt(String rawPassword) {
         return encoder.encode(rawPassword);
    }
   
    public static boolean match(String rawPassword, String password) {
         return encoder.matches(rawPassword, password);  
    }

	public static String encryptByMD5(String clearKey) throws NoSuchAlgorithmException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		byte[] keyByteArr = clearKey.getBytes();
		// 获得MD5摘要算法的 MessageDigest 对象
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		// 使用指定的字节更新摘要
		mdInst.update(keyByteArr);
		// 获得密文
		byte[] md = mdInst.digest();
		// 把密文转换成十六进制的字符串形式
		int ciphertextLength = md.length;
		char charArr[] = new char[ciphertextLength * 2];
		int k = 0;
		for (int index = 0; index < ciphertextLength; index++) {
			byte byte0 = md[index];
			charArr[k++] = hexDigits[byte0 >>> 4 & 0xf];
			charArr[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(charArr);
	}

    public static void main(String[] args) throws NoSuchAlgorithmException {
    	String originalPassword = "test";
    	String passwordEncryotByMD5 = encryptByMD5(originalPassword);
    	System.out.println(passwordEncryotByMD5);
    	System.out.println(passwordEncryotByMD5.length());
    	String s1 = EncryptUtil.encrypt(passwordEncryotByMD5);
    	System.out.println(s1);
    	System.out.println(s1.length());
        System.out.println(match(passwordEncryotByMD5,s1));  
        
    }  
 }  
