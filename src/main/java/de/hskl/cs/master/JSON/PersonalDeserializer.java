package de.hskl.cs.master.JSON;

import java.lang.reflect.Type;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class PersonalDeserializer  implements JsonDeserializer<Actor> {
	 
		
	@Override
	public Actor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		
		 JsonObject jsonObj = json.getAsJsonObject();
		 GsonBuilder gsonBuilder = new GsonBuilder();
		 Gson gson = gsonBuilder
					.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
					.create();
		 
		 
		 String name = jsonObj.get("name").getAsString(); 
		 String gender = jsonObj.get("gender").getAsString(); 
		 Planet homeworld =  gson.fromJson(jsonObj.get("Homeworld"), Planet.class);
		 
		 JsonArray ships = jsonObj.getAsJsonArray("spaceships");
		 JsonArray films = jsonObj.getAsJsonArray("films");
		
		 Actor actor = new Actor(name, gender, homeworld);
			
		 for(JsonElement film : films) {
			 actor.addFilm(gson.fromJson(film, Film.class));
		 }
		 
		 for(JsonElement ship : ships) {
			 actor.addStarship(gson.fromJson(ship, Starship.class));
		 }	
		 return actor;
	}

	
}

	

