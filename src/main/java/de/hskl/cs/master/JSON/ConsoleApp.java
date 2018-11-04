package de.hskl.cs.master.JSON;

import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class ConsoleApp 
{
    public static void main( String[] args )
    {
    
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Bitte Schauspieler ID eingeben. (1 - 87) ");
    	int id = sc.nextInt();
    	if (id < 1)
    		id = 1;
    	else if (id > 87) 
    		id = 87;
    	//int actor_id = 1;
    	
    	Actor opfer = Actor.getActorFromApi(id);
    	System.out.println(opfer.toString());
    	
    	
    }

}
