package com.school.project.util;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class FontUtil {

	private static FontUtil instance;
	private List<Component> smallComponentsBinds;
	private Font small;
	private List<Component> bigComponentsBinds;
	private Font big;
	private List<Component> reallySmallComponentsBinds;
	private Font reallySmall;
	
	private FontUtil(){
		smallComponentsBinds = new ArrayList<>();
		bigComponentsBinds = new ArrayList<>();
		reallySmallComponentsBinds = new ArrayList<>();
	}
	
	public static FontUtil getInstance() {
		if (instance == null) instance = new FontUtil();
		return instance;
	}

	public void bindSmallFont(Component c) {
		c.setFont(getSmallFont());
		smallComponentsBinds.add(c);
	}
	
	public void bindBigFont(Component c) {
		c.setFont(getBigFont());
		bigComponentsBinds.add(c);
	}
	
	public void bindReallySmallFont(Component c) {
		c.setFont(getSmallFont());
		reallySmallComponentsBinds.add(c);
	}

	public void setSmallFont(Font f) {
		if(f == null) return;
		small = f;
		smallComponentsBinds.forEach((c) -> c.setFont(small));
	}

	public void setBigFont(Font f) {
		if(f == null) return;
		big = f;
		bigComponentsBinds.forEach((c) -> c.setFont(big));
	}
	
	public void setReallySmallFont(Font f) {
		if(f == null) return;
		reallySmall = f;
		reallySmallComponentsBinds.forEach((c) -> c.setFont(reallySmall));
	}
	
	public Font getSmallFont() {
		if (small == null) small = new Font("Arial", Font.PLAIN, 24);
		return small;
	}
	
	
	public Font getBigFont() {
		if (big == null) big = new Font("Arial", Font.PLAIN, 30);
		return big;
	}
	
	public Font getReallySmallFont() {
		if (reallySmall == null) reallySmall = new Font("Arial", Font.PLAIN, 14);
		return reallySmall;
	}
}
