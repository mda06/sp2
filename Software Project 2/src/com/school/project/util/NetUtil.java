package com.school.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetUtil {
	public static String curlURL(String url) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("curl", url);
		Process p = pb.start();
		InputStream is = p.getInputStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
			StringBuilder sb = new StringBuilder();
			for (String line; (line = reader.readLine()) != null;) {
				sb.append(line);
			}
			return sb.toString();
		}
	}

	/**
	 * @depreciated 
	 * Doesn't work with Station, but well with the rest
	 * */
	public static String jsonFromURL(String url) throws IOException {
		StringBuilder sb = new StringBuilder();
		URL yahoo = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(yahoo.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();
		return sb.toString();
	}
}
