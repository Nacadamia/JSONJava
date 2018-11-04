package de.hskl.cs.master.JSON;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actor {


Planet homeplanet ;

List<Starship> startships;


@SerializedName("name")
@Expose
private String name;
@SerializedName("height")
@Expose
private String height;
@SerializedName("mass")
@Expose
private String mass;
@SerializedName("hair_color")
@Expose
private String hairColor;
@SerializedName("skin_color")
@Expose
private String skinColor;
@SerializedName("eye_color")
@Expose
private String eyeColor;
@SerializedName("birth_year")
@Expose
private String birthYear;
@SerializedName("gender")
@Expose
private String gender;
@SerializedName("homeworld")
@Expose
private Planet homeworld;
@SerializedName("films")
@Expose
private List<Film> films = null;
@SerializedName("species")
@Expose
private List<Species> species = null;
@SerializedName("vehicles")
@Expose
private List<Vehicle> vehicles = null;
@SerializedName("starships")
@Expose
private List<Starship> starships = null;
@SerializedName("created")
@Expose
private String created;
@SerializedName("edited")
@Expose
private String edited;
@SerializedName("url")
@Expose
private String url;


private static final Client client = ClientBuilder.newClient();

public Actor() {
	super();
	this.films = new LinkedList<Film>();
	this.startships = new LinkedList<Starship>();
}

public static Actor getActorFromApi(int id) {
	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson gson = gsonBuilder
			.registerTypeAdapter(Actor.class, new PersonalDeserializer())
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.setPrettyPrinting()
			.serializeNulls()
			.create();

	String jsonActor = client.target("https://swapi.co/api/").path("people").path(String.valueOf(id))
			.request(MediaType.APPLICATION_JSON)
			.get(String.class);
	
	System.out.println("Objekt roh ausgegeben" + jsonActor);
	
	return gson.fromJson(jsonActor, Actor.class);
}

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

public Planet getHomeplanet() {
	return homeplanet;
}

public void setHomeplanet(Planet homeplanet) {
	this.homeplanet = homeplanet;
}

public void addStarship(Starship ship) {
	startships.add(ship);
}	

public void addFilm(Film film) {
	films.add(film);
}

public void addPlanet(Planet planet) {
	this.homeplanet = planet;
}

public List<Starship> getStartships() {
	return startships;
}

public void setStartships(List<Starship> startships) {
	this.startships = startships;
}

public List<Film> getFilms() {
	return films;
}

public void setFilms(List<Film> films) {
	this.films = films;
	
}
public List<Species> getSpecies() {
	return species;
}

public void setSpecies(List<Species> species) {
	this.species = species;
}

public List<Vehicle> getVehicles() {
	return vehicles;
}

public void setVehicles(List<Vehicle> vehicles) {
	this.vehicles = vehicles;
}


@Override
public String toString() {
	return "Actor \n[name=" + name + ", height=" + height + ", mass=" + mass + ", hairColor=" + hairColor
			+ ", skinColor=" + skinColor + ", eyeColor=" + eyeColor + ", birthYear=" + birthYear + ", gender="
			+ gender + ", homeworld=" + homeworld.toString() + ", films=" + films + ", species=" + species + ", vehicles="
			+ vehicles + ", starships=" + starships + ", created=" + created + ", edited=" + edited + ", url=" + url
			+ "]";
}


}
