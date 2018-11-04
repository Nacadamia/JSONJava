package de.hskl.cs.master.JSON;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

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
	
	private static final Client client = ClientBuilder.newClient();
		
	@Override
	public Actor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		
		 Actor actor = new Actor();
		 JsonObject jsonObj = json.getAsJsonObject();
		 GsonBuilder gsonBuilder = new GsonBuilder();
		 Gson gson = gsonBuilder
					.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
					.create();
		 
		 
		 String name = jsonObj.get("name").getAsString(); 
		 String gender = jsonObj.get("gender").getAsString(); 
		 Planet homeworld =  gson.fromJson(jsonObj.get("Homeworld"), Planet.class);
		 
		 actor.setName(name);
		 actor.setGender(gender);
		 actor.addPlanet(Planet.getPlanetFromApi(jsonObj.get("Homeworld").getAsString()));
		 
		 JsonArray ships = jsonObj.getAsJsonArray("spaceships");
		 JsonArray films = jsonObj.getAsJsonArray("films");
		 JsonArray vehicles = jsonObj.getAsJsonArray("vehicles");
		 JsonArray species = jsonObj.getAsJsonArray("species");
		
		 
			
		 
		 List<Film> f_list = new ArrayList<Film>();
		 for(JsonElement film : films) {
			 f_list.add(Film.getFilmFromApi(film.getAsString()));
		 }
		 	actor.setFilms(f_list);
		 
		 List<Starship> s_list = new ArrayList<Starship>();		
		 for(JsonElement ship : ships) {
			 s_list.add(Starship.getStarshipFromApi(ship.getAsString()));
			 
		 }	
		 actor.setStartships(s_list);
		 
		 List<Vehicle> v_list = new ArrayList<Vehicle>();		
		 for(JsonElement vehicle : vehicles) {
			 v_list.add(Vehicle.getVehicleFromApi(vehicle.getAsString()));
			 
		 }	
		 actor.setVehicles(v_list);
		 
		 List<Species> sp_list = new ArrayList<Species>();		
		 for(JsonElement specie : species) {
			 sp_list.add(Species.getSpeciesFromApi(specie.getAsString()));
	
		 }	
		 actor.setSpecies(sp_list);
		 
		 return actor;
	}

	
}

	

