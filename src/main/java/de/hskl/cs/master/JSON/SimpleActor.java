package de.hskl.cs.master.JSON;

import java.util.LinkedList;
import java.util.List;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SimpleActor {
	private String name;
	private String gender;
	private String homeworld;
	private List<String> films;
	private List<String> spaceships;
	private static final Client client = ClientBuilder.newClient();
	private static Gson gson = new Gson();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public List<String> getSpaceships() {
		return spaceships;
	}

	public void setSpaceships(List<String> spaceships) {
		this.spaceships = spaceships;
	}

	
	 
	
	
	/*Konstruktor
	 * 
	 * */
	
	SimpleActor getLuke(){
	
		String JsonActor = client.target("https://swapi.co/api/people/1")
		.request(MediaType.APPLICATION_JSON)
		.get(String.class);

	return gson.fromJson(JsonActor, SimpleActor.class);
	
	}
	
	
	SimpleActor getPeople() 
	{
		Gson gson = 
    		    new GsonBuilder()
    		    	.registerTypeAdapter(SimpleActor.class, new PersonalSerializer())
    		        .setPrettyPrinting()
    		        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    		        .serializeNulls()
    		        .create();
		
		String JsonActor = client.target("https://swapi.co/api/people/")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);

			return gson.fromJson(JsonActor, SimpleActor.class);
	}
	
	SimpleActor(String name, String gender, String homeworld){
		this.name = name;
		this.gender = gender;
		this.homeworld = homeworld;
		this.spaceships = new LinkedList<String>();
		this.films = new LinkedList<String>();
	}
	
	void addStarship(String spaceship){
		spaceships.add(spaceship);
	}
	
	void addFilm(String film) {
		films.add(film);
	}
	
	@Override
	public String toString() {
		return "Name: " + "\n"+  name + " \nShips: " + spaceships.toString() + "\n" + "Films: " + 
	films.toString();
		
	}
	
	
}
