package com.rmgyantra.GenericUtils;

import io.restassured.response.Response;

public class JsonUtility {
	/**
	 * method will give the data according to the json path passed
	 * @param jsonPath
	 * @param Response
	 * return
	 */
	public String getJsonPathData(String jsonPath,Response response) {
		String result = response.jsonPath().getString(jsonPath);
		return result;
	}
}
