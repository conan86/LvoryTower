package com.tusk.lvoryTower.utils;

import java.math.BigInteger;
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
    
    public static String encryptByMD5(String str) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(str.getBytes());
	    return new BigInteger(1, md.digest()).toString(16);
    }
      
    public static void main(String[] args) throws NoSuchAlgorithmException {
    	String originalPassword = "abcdwerasdfasf12341235";
    	String passwordEncryotByMD5 = encryptByMD5(originalPassword);
    	System.out.println(passwordEncryotByMD5);
    	String s1 = EncryptUtil.encrypt(passwordEncryotByMD5);
    	System.out.println(s1);
    	System.out.println(s1.length());
        System.out.println(match(passwordEncryotByMD5,s1));  
        
    }  
 }  
