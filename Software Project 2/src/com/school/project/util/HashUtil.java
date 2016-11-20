package com.school.project.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
	private static final String BASE_SALT = "POI6UYTREZ76";
	
	public static String getSHA512SecurePassword(String pass) throws UnsupportedEncodingException {
		return getSHA512SecurePassword(pass, BASE_SALT);
	}
	
	public static String getSHA512SecurePassword(String passwordToHash, String salt) throws UnsupportedEncodingException {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes("UTF-8"));
			byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}
