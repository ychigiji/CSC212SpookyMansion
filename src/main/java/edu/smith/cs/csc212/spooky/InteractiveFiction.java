package edu.smith.cs.csc212.spooky;

import java.util.ArrayList;
import java.util.List;

/**
 * This is our main class for SpookyMansion.
 * It interacts with a GameWorld and handles user-input.
 * It can play any game, really.
 *
 * @author jfoley
 *
 */
public class InteractiveFiction {

	/**
	 * This method actually plays the game.
	 * @param input - a helper object to ask the user questions.
	 * @param game - the places and exits that make up the game we're playing.
	 * @return where - the place the player finished.
	 */
	static String runGame(TextInput input, GameWorld game) {
		// This is the current location of the player (initialize as start).
		// Maybe we'll expand this to a Player object.
		String place = game.getStart();

		//initializing GameTime
		GameTime time = new GameTime();
		List<String> things = new ArrayList<>();
		List<String> playerList = new ArrayList<>();
		
		
		// Play the game until quitting.
		// This is too hard to express here, so we just use an infinite loop with breaks.
		while (true) {
			// Print the description of where you are.
			Place here = game.getPlace(place);
			
			System.out.println();
			System.out.println("... --- ...");
			
			here.printDescription(time);
			System.out.println();
			
			//prints out the time in 24hr notation and adds a 0 if time<10
			if (time.getHour() < 10) {
				System.out.println("The time is 0" + time.getHour() + ":00 O'clock");
			}
			//prints out the time in 24hr notation
			if (time.getHour() > 10 ) {
				System.out.println("The time is " + time.getHour() + ":00 O'clock");
			}
			// increase the time by 1hour each time the player moves
			time.increaseHour();
			System.out.println();
			
			//Tells the user whether they have been to a place or not.
			if(here.visited()) {
				System.out.println("It seems you've been here before.");
			}
			here.visit();//
			
			System.out.println();
			// Game over after print!
			if (here.isTerminalState()) {
				break;
			}

			// Show a user the ways out of this place.
			List<Exit> exits = here.getVisibleExits();

			for (int i=0; i<exits.size(); i++) {
				Exit e = exits.get(i);
				System.out.println(" "+i+". " + e.getDescription());
			}

			// Figure out what the user wants to do, for now, only "quit" is special.
			List<String> words = input.getUserWords("?");
			if (words.size() > 1) {
				System.out.println("Only give the system 1 word at a time!");
				continue;
			}

			// Get the word they typed as lowercase, and no spaces.
			// Do not uppercase action -- I have lowercased it.
			String action = words.get(0).toLowerCase().trim();

			if (action.equals("quit") || action.equals("escape") || action.contentEquals("q")) {
				if (input.confirm("Are you sure you want to quit?")) {
					return place;
				} else {
					continue;
				}
			}
			
			
			// take command
			if (action.equals("take")) {
				for (int i = 0; i < here.things.size(); i ++) {
					playerList.add(here.things.get(i));
					}
				if (here.things.size() == 0) {
					System.out.println("There is nothing for you to take");
					continue;
				}
				
				else {
				System.out.println("You have " + playerList);
				here.things.clear();
				continue;
				}
				
				}
			
			// prints out the users items
			if (action.equals("stuff")){
//				for (int i =0; i < playerList.size(); i++) {
						if (playerList.size()== 0) {
									System.out.println("You have nothing");
								}else {	
									System.out.println("You have " + playerList);
								}	
//							}
							continue;
						}
			//Help Command
			if (action.equals("help")) {
				System.out.println("\"Enter a number coresponding to the place thatyou want to visit or quit or q to quit\"");
					continue;
				}
			// Rested, makes time pass twice as fast, when the user types search.
			if (action.equals("rest")) {
				System.out.println(" rested");
				time.increaseHour();
					continue;
				}
			// search allows the user to search an exit
			if (action.equals("search")) {
				here.searchExit();
				continue;
			}
			// From here on out, what they typed better be a number!
			Integer exitNum = null;
			try {
				exitNum = Integer.parseInt(action);
			} catch (NumberFormatException nfe) {
				System.out.println("That's not something I understand! Try a number!");
				continue;
			}

			if (exitNum < 0 || exitNum >= exits.size()) {
				System.out.println("I don't know what to do with that number!");
				continue;
			}

			// Move to the room they indicated.
			Exit destination = exits.get(exitNum);
			place = destination.getTarget();
			
			
			}
			
		// Tells the user how many hours they have spent playing the game.
		System.out.println("You have spent " + time.currentHour + "hours in the GreatZimbabwe.");

		return place;
		
	}

	/**
	 * This is where we play the game.
	 * @param args
	 */
	public static void main(String[] args) {
		// This is a text input source (provides getUserWords() and confirm()).
		TextInput input = TextInput.fromArgs(args);

		// This is the game we're playing.
//		GameWorld game = new SpookyMansion();
		GameWorld game = new GreatZimbabwe();
	

		// Actually play the game.
		runGame(input, game);
		
		// You get here by typing "quit" or by reaching a Terminal Place.
		System.out.println("\n\n>>> GAME OVER <<<");
		
		
	}

}
