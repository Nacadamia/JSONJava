package de.hskl.cs.master.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Gson gson = new Gson();
    	Gson gson = 
    		    new GsonBuilder()
    		        .registerTypeAdapter(Actor.class, new PersonalDeserializer())
    		        //.registerTypeAdapter(DiffContent.class, new MyDeserializer<DiffContent>())
    		        .setPrettyPrinting()
    		        .create();
    	
    	
    	SimpleActor simpleluke = new SimpleActor("Luke Skywalker", "male", "Tatooine"); 
    	simpleluke.addStarship("X-wing");
    	simpleluke.addStarship("Imperial shuttle"); 
    	simpleluke.addFilm("A New Hope");
    	simpleluke.addFilm("The Empire Strikes Back");
    	simpleluke.addFilm("Return of the Jedi");
    	simpleluke.addFilm("Revenge of the Sith");
    	simpleluke.addFilm("The Force Awakens");
    	
    	
    	SimpleActor sactor = gson.fromJson(gson.toJson(simpleluke), SimpleActor.class);  
    	
    	System.out.println("SimpleLuke:" + gson.toJson(simpleluke));
    	System.out.println("Simpleactor:" + gson.toJson(sactor));

    
    	Actor luke = new Actor("Luke Skywalker", "male", new Planet("Tatooine")); 
    	luke.addStarship( new Starship("X-wing") );
    	luke.addStarship( new Starship("Imperial shuttle") ); 
    	luke.addFilm( new Film("A New Hope") ); 
    	luke.addFilm( new Film("The Empire Strikes Back") );
    	luke.addFilm( new Film("Return of the Jedi") );
    	luke.addFilm( new Film("Revenge of the Sith") );
    	luke.addFilm( new Film("The Force Awakens") );
    	
    	
    	System.out.println("Actor" + gson.toJson(luke));
    	
    	Actor actor = gson.fromJson("Actor from SimpleLuke" + gson.toJson(simpleluke), Actor.class);
    	
    	System.out.println(gson.toJson(actor));
    }

}
