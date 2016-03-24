package com.tusk.lvoryTower.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncryptUtil {
	private static final String SITE_WIDE_SECRET = "my-secret-key-lvory-tower";
	private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);

	public static String encryptPassword(String originalPassword) {
		String result = encoder.encode(originalPassword);
		return result;
	}

	public static boolean passwordMatch(String rawPassword, String originalPassword) {
		return encoder.matches(rawPassword, originalPassword);
	}

	public static String encryptByMD5(String clearKey) throws NoSuchAlgorithmException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		byte[] keyByteArr = clearKey.getBytes();
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		mdInst.update(keyByteArr);
		byte[] md = mdInst.digest();
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

	public static byte[] encryptAES128(byte[] byteContent, String password) throws Exception {

		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = cipher.doFinal(byteContent);
		return result;
	}

	public static byte[] decryptAES128(byte[] ciphertext, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
		byte[] result = cipher.doFinal(ciphertext);
		return result;
	}

	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		String originalPassword = "test";
		String passwordEncryptByMD5 = encryptByMD5(originalPassword);
		System.out.println(originalPassword + " After MD5 encrypt" + passwordEncryptByMD5);
		System.out.println(passwordEncryptByMD5.length());
		String s1 = EncryptUtil.encryptPassword(passwordEncryptByMD5);
		System.out.println(s1);
		System.out.println(s1.length());
		System.out.println(passwordMatch(passwordEncryptByMD5, s1));

		String content = "Conan Sun";
		String password = "sxn_124345";
		System.out.println("加密前：" + content);
		byte[] encryptResult = encryptAES128(content.getBytes("utf-8"), password);
		String encryptResultStr = parseByte2HexStr(encryptResult);
		System.out.println("加密后：" + encryptResultStr);
		// 解密
		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
		byte[] decryptResult = decryptAES128(decryptFrom, password);
		System.out.println("解密后：" + new String(decryptResult));
	}
}
