package de.hskl.cs.master.JSON;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	int actor_id = 1;
    	
    //	Actor opfer = Actor.getActorFromApi(actor_id);
    //	System.out.println(opfer.toString());
    	
    	
    	//Aufgabe 9
    	
    	SimpleActor servus = new SimpleActor(null, null, null).getPeople();
    	
    	
    	System.out.println(servus.toString());
    	
    	//System.out.println(gson.toJson(opfer));
    	
    	
    	/**
    	SimpleActor simpleluke = new SimpleActor("Luke Skywalker", "male", "Tatooine"); 
    	simpleluke.addStarship("X-wing");
    	simpleluke.addStarship("Imperial shuttle"); 
    	simpleluke.addFilm("A New Hope");
    	simpleluke.addFilm("The Empire Strikes Back");
    	simpleluke.addFilm("Return of the Jedi");
    	simpleluke.addFilm("Revenge of the Sith");
    	simpleluke.addFilm("The Force Awakens");
    	
    	
    	SimpleActor sactor = gson.fromJson(gson.toJson(simpleluke), SimpleActor.class);  
    	
    	SimpleActor zwei = new SimpleActor("","","");
    	System.out.println("GetLuke: " + gson.toJson(zwei.getLuke()));
    	
    	System.out.println("SimpleLuke:" + gson.toJson(simpleluke));
    	System.out.println("Simpleactor:" + gson.toJson(sactor));

    
    	Actor luke = new Actor(); 
    	luke.setName("Luke Skywalker");
    	luke.setGender("male");
    	luke.addPlanet(new Planet());
    	luke.addStarship( new Starship("X-wing") );
    	luke.addStarship( new Starship("Imperial shuttle") ); 
    	luke.addFilm( new Film("A New Hope") ); 
    	luke.addFilm( new Film("The Empire Strikes Back") );
    	luke.addFilm( new Film("Return of the Jedi") );
    	luke.addFilm( new Film("Revenge of the Sith") );
    	luke.addFilm( new Film("The Force Awakens") );
    	
    	
    	System.out.println("Actor" + gson.toJson(luke));
    	
    	//Actor actor = gson.fromJson("Actor from SimpleLuke" + gson.toJson(simpleluke), Actor.class);
    	
    	//System.out.println(gson.toJson(actor));
    	**/
    }

}
