package de.hskl.cs.master.JSON;

import java.util.LinkedList;
import java.util.List;

public class Actor {
String name, gender; 
Planet homeplanet ;
List<Film> films;
List<Starship> startships;


public Actor(String name, String gender, Planet homeplanet) {
	super();
	this.name = name;
	this.gender = gender;
	this.homeplanet = homeplanet;
	this.films = new LinkedList<Film>();
	this.startships = new LinkedList<Starship>();
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

}
