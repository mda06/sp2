package com.school.project;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.school.project.gui.MainFactory;
import com.school.project.util.NetUtil;

public class Main {
	private static boolean testIfCurlIsActive() {
		try {
			NetUtil.curlURL("https://www.google.com");
		} catch (IOException io) {
			io.printStackTrace();
			JOptionPane.showMessageDialog(null, "CURL is not installed on this PC, please install curl before to use this program");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		if (testIfCurlIsActive()) 
			new MainFactory().showLoginFrame();
	}
}
