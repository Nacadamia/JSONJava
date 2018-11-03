package de.hskl.cs.master.JSON;

import java.lang.reflect.Type;

import com.google.gson.Gson;
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
		 String name = jsonObj.get("name").getAsString(); 
		 String gender = jsonObj.get("gender").getAsString(); 
		 String homeworld = jsonObj.get("homeworld").getAsString();
		 JsonElement ships = jsonObj.getAsJsonObject().get("spaceships");
		 JsonElement films = jsonObj.getAsJsonObject("films");
		 //String telefonNr = jsonObj.get("TelefonNr").getAsString();
	Actor actor = new Actor(name, gender, new Planet(homeworld));
			actor.addStarship(new Gson().fromJson(ships, Starship.class));
			actor.addFilm(new Gson().fromJson(films, Film.class));
	return actor; }

}

	

