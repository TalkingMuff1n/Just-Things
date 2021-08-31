/**
 * ---------------------------------------------------------------------------
 * File name: project5Driver.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 12, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;

import java.util.Random;
import java.util.Scanner;

/**
 * This is the main program, or the driver, and it holds the menu and everything else in it, works the magic if you will :)
 *
 * <hr>
 * Date created: Apr 12, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class project5Driver
{

	/**
	 * stand public static void main String args for ya         
	 *
	 * <hr>
	 * Date created: Apr 12, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		
		// TODO Auto-generated method stub
		wyvern wyve = new wyvern();
		Random r = new Random(); //used for some random
		Random k = new Random(); //I have a second one that I don't need, but its 3 hours before and due and.. ya know
		int sizeRows, sizeCols; //determines the size of the map
		sizeRows = k.nextInt(3) + 3; //random size mininum of 3 maximum of 5
		sizeCols = k.nextInt(7) + 4; //random size mininum of 4 maximum of 10
	 	int exitGeneratorRow = k.nextInt(sizeRows); //generate the exit
	 	int exitGeneratorCol = sizeCols - 1; //generate the exit
		String[][] cells = new String[sizeRows][sizeCols]; //generate the array
		boolean hasSw = false; //needed for spawning weapons
		boolean hasSt = false;
		boolean hasPs = false;
		boolean hasSh = false;
		boolean hasMS = false;
		for(int i = 0; i<sizeRows; i++) {
			for(int j = 0; j<sizeCols; j++) {
				cells[i][j] = "";
				if(i == 0 && j == 0) {
					cells[i][j] = "|P____|";
				} //puts the player in the first cell 
				if(r.nextInt(10000) < 5000 ) { //50% of spawning monster
					if(i == 0 && j == 0) {
						
					}else {
						cells[i][j] = "|_M___|";
					}
				} 
				if(r.nextInt(10000) < 1000  && !hasSw) { //10% of spawning sword
					if(cells[i][j].equals("")) {
						cells[i][j] = "|__Sw_|";
						hasSw = true;
						
					}else {
						StringBuilder sb = new StringBuilder(cells[i][j]);
						sb.deleteCharAt (3);
						sb.deleteCharAt (3);
						sb.insert (3, "Sw");
						cells[i][j] = sb.toString ( );
						hasSw = true;
					}
				} 
				if(r.nextInt(10000) < 1000 && !hasSt) { //10% chance of spawning stick
					if(cells[i][j].equals("")) {
						cells[i][j] = "|__St_|";
						hasSt = true;
						
					}else {
						StringBuilder sb = new StringBuilder(cells[i][j]);
						sb.deleteCharAt (3);
						sb.deleteCharAt (3);
						sb.insert (3, "St");
						cells[i][j] = sb.toString ( );
						hasSt = true;
					}
				}
				if(r.nextInt(10000) < 1000 && !hasPs) { //10% chance of spawning pistols
					if(cells[i][j].equals("")) {
						cells[i][j] = "|__Ps_|";
						hasPs = true;
						
					}else {
						StringBuilder sb = new StringBuilder(cells[i][j]);
						sb.deleteCharAt (3);
						sb.deleteCharAt (3);
						sb.insert (3, "Ps");
						cells[i][j] = sb.toString ( );
						hasPs = true;
					}
				}
				if(r.nextInt(10000) < 1000 && !hasSh) { //10% chance of spawning shield
					if(cells[i][j].equals("")) {
						cells[i][j] = "|__Sh_|";
						hasSh = true;
						
					}else {
						StringBuilder sb = new StringBuilder(cells[i][j]);
						sb.deleteCharAt (3);
						sb.deleteCharAt (3);
						sb.insert (3, "Sh");
						cells[i][j] = sb.toString ( );
						hasSh = true;
					}
				}
				if(r.nextInt(10000) < 1000 && !hasMS) { //10% chance of spawning magic sword
					if(cells[i][j].equals("")) {
						cells[i][j] = "|__ms_|";
						hasMS = true;
						
					}else {
						StringBuilder sb = new StringBuilder(cells[i][j]);
						sb.deleteCharAt (3);
						sb.deleteCharAt (3);
						sb.insert (3, "ms");
						cells[i][j] = sb.toString ( );
						hasMS = true;
					}
				}
				if(r.nextInt(10000) < 500 ) { //5% chance of spawning elixir
					if(cells[i][j].equals ("")) {
						cells[i][j] = "|____E|";
					}else {
						StringBuilder sb = new StringBuilder(cells[i][j]);
						sb.deleteCharAt (5);
						sb.insert (5, "E");
						cells[i][j] = sb.toString ( );
					}
				}
				if(cells[i][j].equals ("")){
					cells[i][j] = "|_____|";
				}
			}
		}
		Scanner in = new Scanner(System.in); //for user input
		String input; //for manipulating input
		int column = 0, row = 0; //keeping up with the player
		player playerOne = new player(); //generating new player
		sword sw = new sword(); //used for adding weapons to inventory
		stick st = new stick();
		pistols ps = new pistols();
		shield sh = new shield();
		magicSword ms = new magicSword();
		boolean game = true; //used to get the while loop looping
		boolean onBoot = true; //used to do things on first iteration
		boolean onBoot2 = false; //used to do things on first iteration
		while(game) {
			if(onBoot) {
				for(int i = 0; i<sizeRows; i++) {
					for(int j = 0; j<sizeCols; j++) {
						System.out.print(cells[i][j]);
					}
					System.out.println();
				}
				//the following statements are only on the boot of the game, simply to pick up whatever weapon is in the starting cell (if there is one)
				//also elixirs same thing ^
				if(cells[column][row].contains ("Sw")) {
					playerOne.addWeaponToInventory (sw);
					System.out.println("You picked up a Sword!");
					System.out.println("Sword has been added to your inventory");
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (3);
					sb.deleteCharAt (3);
					sb.insert (3, "_");
					sb.insert (3, "_");
					cells[column][row] = sb.toString ( );
				}
				if(cells[column][row].contains("St")) {
					playerOne.addWeaponToInventory (st);
					System.out.println("You picked up a Stick!");
					System.out.println("Stick has been added to your inventory");
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (3);
					sb.deleteCharAt (3);
					sb.insert (3, "_");
					sb.insert (3, "_");
					cells[column][row] = sb.toString ( );
				}
				if(cells[column][row].contains("Ps")) {
					playerOne.addWeaponToInventory (ps);
					System.out.println("You picked up a set of pistols!");
					System.out.println("Pistols has been added to your inventory");
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (3);
					sb.deleteCharAt (3);
					sb.insert (3, "_");
					sb.insert (3, "_");
					cells[column][row] = sb.toString ( );
				}
				if(cells[column][row].contains ("Sh")) {
					playerOne.addWeaponToInventory (sh);
					System.out.println("You picked up a shield!");
					System.out.println("Shield has been added to your inventory");
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (3);
					sb.deleteCharAt (3);
					sb.insert (3, "_");
					sb.insert (3, "_");
					cells[column][row] = sb.toString ( );
				}
				if(cells[column][row].contains ("ms")) {
					playerOne.addWeaponToInventory (ms);
					System.out.println("You picked up a Magic Sword.. What's it do anyway?");
					System.out.println("Magic Sword has been added to your inventory");
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (3);
					sb.deleteCharAt (3);
					sb.insert (3, "_");
					sb.insert (3, "_");
					cells[column][row] = sb.toString ( );
				}
				
				if(cells[column][row].contains ("E")) {
					playerOne.addElixirToInventory ( );
					System.out.println("You pick up an Elixir!");
					System.out.println("You now have " + playerOne.checkElixirs ( ) + " Elixirs");
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (5);
					sb.insert (5, "_");
					cells[column][row] = sb.toString ( );
				}
				
				onBoot = false;
			}
			
			
			
			if(onBoot2) { //this only does it the first time
				for(int i = 0; i<sizeRows; i++) {
					for(int j = 0; j<sizeCols; j++) {
						System.out.print(cells[i][j]);
					}
					System.out.println();
				}
			}
			
			onBoot2 = true;
			
			//the following code is the movement of the player, and how he navigates the cells, only north, south, east, west
			
			System.out.println("Where would you like to go?");
			input = in.nextLine( );
			input = input.toUpperCase();
			if(input.equals("GO SOUTH")) {
				if(column < sizeRows-1) { 
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (1);
					sb.insert (1, "_");
					cells[column][row] = sb.toString ( );
					column++;
					StringBuilder sb2 = new StringBuilder(cells[column][row]);
					sb2.deleteCharAt (1);
					sb2.insert (1, "P");
					cells[column][row] = sb2.toString ( );
				}else {
					System.out.println("You can't go South right now");
				}
			}
			if(input.equals("GO EAST")) {
				if(row < sizeCols-1) {
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (1);
					sb.insert (1, "_");
					cells[column][row] = sb.toString ( );
					row++;
					StringBuilder sb2 = new StringBuilder(cells[column][row]);
					sb2.deleteCharAt (1);
					sb2.insert (1, "P");
					cells[column][row] = sb2.toString ( );
				}else if(row == exitGeneratorCol && column == exitGeneratorRow){ //this is to check to see if you found the exit on the right side of the map
					System.out.println("You found the exit to the dungeon!");
					System.out.println("A shadow covers you overhead! It's a Wyvern!");
					System.out.println("Get Ready to Fight!");
					boolean bossAlive = true;
					String command;
					while(bossAlive) { //duplicate while specifically for wyvern (final boss) then if you beat him game ends, if not, game still ends lol
								System.out.println("What would you like to do?");
								System.out.println("\tAttack\t\tDrink Elixir\n\tEquip Weapon\t\tCheck Inventory");
								command = in.nextLine( );
								command = command.toUpperCase ( );
								if(command.equals ("ATTACK")) {
									bossAlive = playerOne.initiateCombat (wyve, bossAlive);
								}
								if(command.equals ("DRINK ELIXIR")) {
									playerOne.drinkElixir ( );
								}
								if(command.equals ("EQUIP WEAPON")) {
									boolean checker = false;
									while(!checker) {
										int index;
										try {
											System.out.println("Which weapon would you like to equip?");
											playerOne.checkWeapons ( );
											command = in.nextLine();
											index = Integer.parseInt (command);
											playerOne.equipWeapon (index, in);
											checker = true;
										} catch(Exception e) {
											System.out.println("You need to choose between the weapons you have!\nPlease enter the number next to the weapon.");
										}
										
									}
									
								}
								if(command.equals ("CHECK INVENTORY")) {
									
								}
								
						
					}
					System.out.println ("Congratulations! You beat the Mighty Wyvern! And guess what? You beat the game!" );
					System.exit (0);
				}else {
					System.out.println("You can't go East right now.");
				}
			}
			if(input.equals("GO NORTH")) {
				if(column > 0) {
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (1);
					sb.insert (1, "_");
					cells[column][row] = sb.toString ( );
					column--;
					StringBuilder sb2 = new StringBuilder(cells[column][row]);
					sb2.deleteCharAt (1);
					sb2.insert (1, "P");
					cells[column][row] = sb2.toString ( );
				}else {
					System.out.println("You can't go North right now.");
				}
			}
			if(input.equals("GO WEST")) {
				if(row > 0) {
					StringBuilder sb = new StringBuilder(cells[column][row]);
					sb.deleteCharAt (1);
					sb.insert (1, "_");
					cells[column][row] = sb.toString ( );
					row--;
					StringBuilder sb2 = new StringBuilder(cells[column][row]);
					sb2.deleteCharAt(1);
					sb2.insert (1, "P");
					cells[column][row] = sb2.toString ( );
				}else {
					System.out.println("You can't go West right now.");
				}
			}
			//same statements as above, except these are when you enter a new cell, you pick up the item before you fight the monster, so you can still
			//use it in the fight
			if(cells[column][row].contains ("Sw")) {
				playerOne.addWeaponToInventory (sw);
				System.out.println("You picked up a Sword!");
				System.out.println("Sword has been added to your inventory");
				StringBuilder sb = new StringBuilder(cells[column][row]);
				sb.deleteCharAt (3);
				sb.deleteCharAt (3);
				sb.insert (3, "_");
				sb.insert (3, "_");
				cells[column][row] = sb.toString ( );
			}
			if(cells[column][row].contains("St")) {
				playerOne.addWeaponToInventory (st);
				System.out.println("You picked up a Stick!");
				System.out.println("Stick has been added to your inventory");
				StringBuilder sb = new StringBuilder(cells[column][row]);
				sb.deleteCharAt (3);
				sb.deleteCharAt (3);
				sb.insert (3, "_");
				sb.insert (3, "_");
				cells[column][row] = sb.toString ( );
				
			}
			if(cells[column][row].contains("Ps")) {
				playerOne.addWeaponToInventory (ps);
				System.out.println("You picked up a set of pistols!");
				System.out.println("Pistols has been added to your inventory");
				StringBuilder sb = new StringBuilder(cells[column][row]);
				sb.deleteCharAt (3);
				sb.deleteCharAt (3);
				sb.insert (3, "_");
				sb.insert (3, "_");
				cells[column][row] = sb.toString ( );
			}
			if(cells[column][row].contains ("Sh")) {
				playerOne.addWeaponToInventory (sh);
				System.out.println("You picked up a shield!");
				System.out.println("Shield has been added to your inventory");
				StringBuilder sb = new StringBuilder(cells[column][row]);
				sb.deleteCharAt (3);
				sb.deleteCharAt (3);
				sb.insert (3, "_");
				sb.insert (3, "_");
				cells[column][row] = sb.toString ( );
			}
			if(cells[column][row].contains ("ms")) {
				playerOne.addWeaponToInventory (ms);
				System.out.println("You picked up a Magic Sword.. What's it do anyway?");
				System.out.println("Magic Sword has been added to your inventory");
				StringBuilder sb = new StringBuilder(cells[column][row]);
				sb.deleteCharAt (3);
				sb.deleteCharAt (3);
				sb.insert (3, "_");
				sb.insert (3, "_");
				cells[column][row] = sb.toString ( );
			}
			
			if(cells[column][row].contains ("E")) {
				playerOne.addElixirToInventory ( );
				System.out.println("You pick up an Elixir!");
				System.out.println("You now have " + playerOne.checkElixirs ( ) + " Elixirs");
				StringBuilder sb = new StringBuilder(cells[column][row]);
				sb.deleteCharAt (5);
				sb.insert (5, "_");
				cells[column][row] = sb.toString ( );
			}
			
			
			//constantly tells you your hp
			System.out.println("Player has " + playerOne.getHealth() + " HP");
			
			//monster algorithm
			if(cells[column][row].contains ("M")) { //checks for monster
				
				for(int i = 0; i<sizeRows; i++) {
					for(int j = 0; j<sizeCols; j++) {
						System.out.print(cells[i][j]);
					}
					System.out.println();
				}
				
				System.out.println("There is a monster here!"); //user confirmation
				int switcher = r.nextInt(3) + 1; //generates what type of monster it will be
				skeleton s = null; //initialize the variables
				ghoul g = null;
				undeadSoldier u = null;
				wyvern w = null;
				switch(switcher) {
					case 1:
						s = new skeleton();
						System.out.println("It's a skeleton.");
						break;
					case 2:
						g = new ghoul();
						System.out.println("It's a ghoul.");
						break;
					case 3:
						u = new undeadSoldier();
						System.out.println("It's an undead soldier");
						break;
				}
				String command; //takes input
				boolean checker = false; //checks for false input
				boolean monsterAlive = true; //checks if the monster is still alive also passed into method
					while(monsterAlive) {
						
						System.out.println("What would you like to do?");
						System.out.println("\tAttack\t\tDrink Elixir\n\tEquip Weapon\t\tCheck Inventory"); //menu, takes exact input, except caps don't matter
						command = in.nextLine( );
						command = command.toUpperCase ( );
						if(command.equals ("ATTACK")) {
							if(switcher == 1) {
								monsterAlive = playerOne.initiateCombat (s, monsterAlive);
							}
							if(switcher == 2) {
								monsterAlive = playerOne.initiateCombat (g, monsterAlive);
							}
							if(switcher == 3) {
								monsterAlive = playerOne.initiateCombat (u, monsterAlive);
							}
							
						}
						if(command.equals ("DRINK ELIXIR")) { //restore health
							playerOne.drinkElixir();
							System.out.println("Your HP is now" + playerOne.getHealth());
						}
						if(command.equals ("EQUIP WEAPON")) { //equip weapon
							while(!checker) {
								int index;
								try {
									System.out.println("Which weapon would you like to equip?");
									playerOne.checkWeapons ( );
									command = in.nextLine();
									index = Integer.parseInt (command);
									playerOne.equipWeapon (index, in);
									checker = true;
								} catch(Exception e) {
									System.out.println("You need to choose between the weapons you have!\nPlease enter the number next to the weapon.");
								}
								
							}
							
						}
						if(command.equals ("CHECK INVENTORY")) { //basically a toString()
							playerOne.checkInventory ( );
						}
						StringBuilder sb = new StringBuilder(cells[column][row]); //gets rid of monster on map
						sb.deleteCharAt (2);
						sb.insert (3, "_");
						cells[column][row] = sb.toString ( );
					}
				
			}
		}
		in.close(); //close the scanner
	}
}
