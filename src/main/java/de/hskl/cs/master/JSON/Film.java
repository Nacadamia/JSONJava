package de.hskl.cs.master.JSON;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film {
	
	/*String title,episode_id,opening_crawl,director,producer,release_date, created, edited, url;
	ArrayList<String> planets = new ArrayList<String>();
	ArrayList<String> starships = new ArrayList<String>();
	ArrayList<String> vehicles = new ArrayList<String>();
	ArrayList<String> species = new ArrayList<String>();
	ArrayList<String> characters = new ArrayList<String>();
	*/
	private static final Client client = ClientBuilder.newClient();
	
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("episode_id")
	@Expose
	private Integer episodeId;
	@SerializedName("opening_crawl")
	@Expose
	private String openingCrawl;
	@SerializedName("director")
	@Expose
	private String director;
	@SerializedName("producer")
	@Expose
	private String producer;
	@SerializedName("release_date")
	@Expose
	private String releaseDate;
	@SerializedName("characters")
	@Expose
	private List<String> characters = null;
	@SerializedName("planets")
	@Expose
	private List<String> planets = null;
	@SerializedName("starships")
	@Expose
	private List<String> starships = null;
	@SerializedName("vehicles")
	@Expose
	private List<String> vehicles = null;
	@SerializedName("species")
	@Expose
	private List<String> species = null;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("edited")
	@Expose
	private String edited;
	@SerializedName("url")
	@Expose
	private String url;
	
	/**
	 * Konstruktoren
	 */
	public Film() {
		super();
	}
	
	public Film(String title) 
	{
		this.title = title;
	}
	
	/*
	 * Film von der API instanziieren
	 * */
	public static Film getFilmFromApi(String URL){
		Gson gson = 
    		    new GsonBuilder()
    		        .setPrettyPrinting()
    		        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    		        .serializeNulls()
    		        .create();
		
		String Filmson = client.target(URL)
			.request(MediaType.APPLICATION_JSON)
			.get(String.class);
		
	return 	gson.fromJson(Filmson, Film.class);
		
	}
	
	
}
