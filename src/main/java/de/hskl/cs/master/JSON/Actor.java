package de.hskl.cs.master.JSON;

import java.util.LinkedList;
import java.util.List;

public class Actor {

String name, gender; 
Planet homeplanet ;
List<Film> films;
List<Starship> startships;


public Actor() {
	super();
	this.films = new LinkedList<Film>();
	this.startships = new LinkedList<Starship>();
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

}
