package de.hskl.cs.master.JSON;

import java.util.LinkedList;
import java.util.List;

public class SimpleActor {
	private String name;
	private String gender;
	private String homeworld;
	private List<String> films;
	private List<String> spaceships;
	
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
	
	
}
