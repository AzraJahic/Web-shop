package com.product.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.model.ClientMessage;

public class JsonUtil {

	private static ObjectMapper objectMapper;
	
	static {
		objectMapper = new ObjectMapper();
	}
	
	public static String convertObjectToJSON(Object obj) {
		String jsonString = "";
		
		try {
			jsonString = objectMapper.writeValueAsString(obj);
		}
		catch (JsonProcessingException e) {
			System.out.println("JsonUtil | JsonProcessingException occured while trying to convert object to JSON.");
		}
		
		return jsonString;
	}

	public static ClientMessage convertJSONtoClientMessage(String jsonString) {
		//Find out how to do this.
		ClientMessage clientMessage = null;
		try {
			clientMessage = objectMapper.readValue(jsonString, ClientMessage.class);
		} catch (JsonMappingException e) {
			System.out.println("JsonUtil ::: convertJSONtoClientMessage FAILED AT JsonMappingException");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			System.out.println("JsonUtil ::: convertJSONtoClientMessage FAILED AT JsonProcessingException");
			e.printStackTrace();
		}
		
		return clientMessage;
	}
	
}