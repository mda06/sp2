package com.school.project.util;

import java.awt.Font;

public class FontUtil {

	private static FontUtil instance;
	private Font small;
	private Font big;
	
	private FontUtil(){
	}
	
	public static FontUtil getInstance() {
		if (instance == null) instance = new FontUtil();
		return instance;
	}
	public Font getSmall() {
		if (small == null) small = new Font("Arial", Font.PLAIN, 24);
		return small;
	}
	public Font getBig() {
		if (big == null) big = new Font("Arial", Font.PLAIN, 30);
		return big;
	}
}
