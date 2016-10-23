package com.school.project.nmbs.dao;

import org.json.JSONObject;

import com.school.project.nmbs.model.PlatformInfo;

public class PlatformDAO {
	public static PlatformInfo getPlatformInfoWithJSON(JSONObject obj) {
		String name = obj.getString("name");
		String normal = obj.getString("normal");
		return new PlatformInfo(name, normal);
	}
}
