package de.hskl.cs.master.JSON;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class PersonalSerializer implements JsonSerializer<String> {

	
	@Override
	public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
       
				return jsonObject;
	}

}