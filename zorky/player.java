/**
 * ---------------------------------------------------------------------------
 * File name: player.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky; //package name

import java.util.Random; //imports for etc.
import java.util.Scanner;

/**
 * This is basically a class that is used to do things like combat and to represent the player his health and inventory which is a separate class
 * but it also has the attributes for when you fight the wyvern, froze and burned, to see if you can't attack or if you get burned and lose hp until you 
 * recover from the burn, it also has the weapon attribute which is your equipped weapon
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class player
{
	private int health;
	private int damage;
	private inventory i;
	private weapon w;
	private boolean froze;
	private boolean burned;
	
	
	
	/**
	 * This is a basic constructor which basically just gives you your base health, and base damage, your starting inventory (with 3 elixirs) no weapon equipped
	 * and you aren't frozen or burned starting out       
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * 
	 */
	public player() {
		health = 100;
		damage = 5;
		i = new inventory();
		w = null;
		froze = false;
		burned = false;
	}
	
	/**
	 * Used to retrieve or return the health attribute, used in calculating health and damage         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Used to set the health attribute, used in calculating health and damage         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * This is an attribute I had to give everyone due to the magic sword, and the wyvern, they both have attribute of freezing, so then you have to have to be
	 * frozen somehow!         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void setFroze() {
		froze = !froze;
	}
	
	/**
	 * Same as the above, except it's burned or burning         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void setBurned() {
		burned = !burned;
	}
	
	/**
	 * This is used in the logic of initiate combat to determine if you lose health during the turn         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public boolean checkBurned() {
		return burned;
	}
	
	/**
	 * This is used in the logic of initiate combat to determine if you cannot attack this turn, but you can still change equipped weapon and drink elixirs         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public boolean checkFroze() {
		return froze;
	}
	
	
	/**
	 * This is used to equip weapons. The main purpose here to modify the damage of the player, but of course, with different weapons, you can't just keep on 
	 * adding on damage according to how many weapons you have, so you have to subtract the damage of the last weapon they had, or if they didn't have a weapon previously
	 * then you don't subtract anything
	 * 
	 * Also for the magic sword, you have to choose what element you want, so in order to use a scanner in a class besides main, you have to pass the 
	 * scanner from main to player, and then use it, receive input based on what element the player wants, and then everything else is coded in either the 
	 * driver or here under initiate combat
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param index
	 * @param scan
	 */
	public void equipWeapon(int index, Scanner scan) {
		if(this.w == null) {
			this.w = i.getWeapon(index);
			System.out.println( "You have equipped " + w.toString ( ) + ".");
			damage = damage + w.getDamageBuff ( );
		}else {
			damage = damage - w.getDamageBuff ( );
			this.w = i.getWeapon(index);
			System.out.println( "You have equipped " + w.toString ( ) + ".");
			damage = damage + w.getDamageBuff ( );
		}
		if(w instanceof magicSword) {
			boolean elementNotChose = true;
			while(elementNotChose) {
				System.out.println("Choose Your Element");
				System.out.println("\tFire\tIce\tLightning");
				String element = scan.nextLine ( );
				element = element.toUpperCase ( );
				if(element.equals ("FIRE")) {
					((magicSword) w).setElementFire ( );
					elementNotChose = false;
				}else if(element.equals ("ICE")) {
					((magicSword) w).setElementIce ( );
					elementNotChose = false;
				}else if(element.equals ("LIGHTNING")) {
					((magicSword) w).setElementLightning ( );
					elementNotChose = false;
				}else {
					System.out.println("You have to make a valid selection!");
				}
			}
			
		}
	}
	
	/**
	 * This is the damage roll, which in any good game, you don't always do the same amount of damage for every shot or hit, so you it rolls it. base damage
	 * fluctuates between 4-6 and then it goes up from there based on the damage buff, but I have some tougher enemies like the undead soldier and the map
	 * can get pretty challenging         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getDamageRoll() {
		Random r = new Random();
		int damageFlux = damage/2;
		int damageRoll = r.nextInt(damageFlux) + damage - damageFlux/2;
		return damageRoll;
	}
	
	/**
	 * This requires use of the inventory class, which very simply holds and stores weapons, and also carries your elixirs
	 * 
	 * This just basically gives you health and takes away an elixir, or you drink an elixir however you wanna look at it
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void drinkElixir() {
		this.health += 10;
		System.out.println("You drank an elixir for 10 HP");
		System.out.println("You now have " + getHealth());
		i.drinkElixir ( );
		System.out.println("Now you have " + i.checkElixirs ( ) + " Elixirs");
	}
	
	/**
	 * This is used when there is an elixir on the map, you pick it up, and it passes it to the inventory to store         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void addElixirToInventory() {
		i.addElixir ( );
	}
	
	/**
	 * This is used for user confirmation, to let them know how many elixirs they have         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int checkElixirs() {
		return i.checkElixirs ( );
	}
	
	/**
	 * This is used when you are equipping a weapon, it sprawls out your inventory so you can choose a weapon         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void checkWeapons() {
		i.weaponsOut ( );
	}
	
	/**
	 * This is mainly here to check the number of elixirs you have in your inventory, but also to see your weapons        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void checkInventory() {
		System.out.println(i.toString());
	}
	
	/**
	 * This is when you pick up a weapon, it adds it to your inventory         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param w
	 */
	public void addWeaponToInventory(weapon w) {
		i.addWeapon (w);
	}
	
	/**
	 * This is to just see what weapon you are using, probably used in the logic but I can't remember, seems like it is though.. I don't know why it's here         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public weapon checkWeapon() {
		return w;
	}
	
	/**
	 * This one is a little tough, but basically it does the combat between you and whatever creature you encounter in the dungeon, it makes it to where you
	 * have turns essentially and actually push the attack button or type 'attack' over and over after you've equipped a weapon or drank an elixir
	 * 
	 * I'm going to do some commenting within this block of code, since it is about 200 lines
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param m
	 * @param b
	 * @return
	 */
	public boolean initiateCombat(monster m, boolean b) {
		Random r = new Random(); //need for various
		boolean healed = false; //check to see if they can attack that turn
		boolean magicBreath = false; //specifically for the wyvern and see if he can attack that turn, he can't if he has used magic breath
		System.out.println("Player attacks the " + m.getName() ); //user information
		int playerDamage = getDamageRoll(); // calculates the damage for the player and stores it
		int monsterDamage = m.getDamageRoll ( ); //calculates the damage for the mosnter and stores it
		if(r.nextInt(10000) < 3500 && m.checkFroze ( )) {
			m.setFroze ( ); //chance of unfreezing (monster) at beginning of turn
			System.out.println("The " + m.getName() + " has thawed out.");
		}
		if(m.checkBurning ( )) {
			m.setHealth (m.getHealth ( ) - 2); //takes health away for the burn (monster)
			System.out.println("The " + m.getName() + " is hurt by the burn from last time\n" + "He loses 2 HP");
		}
		if(r.nextInt(10000) < 3500 && m.checkBurning ( )) {
			System.out.println("The " + m.getName() + " has recovered from the burn.");
			m.setBurning ( ); //flips burning back and forth, but since it burning has to be true, it only acts when burnt (monster)
		}
		if(r.nextInt(10000) < 3500 && checkFroze ( )) {
			System.out.println("You have thawed out.");
			setFroze(); //unfreeze the player
		}
		if(checkBurned()) {
			setHealth(getHealth() - 2); //health taken by burn (player)
			System.out.println("You are hurt by the burn given to you by the wyvern. You lose 2 HP");
		}
		if(r.nextInt(10000) < 3500 && checkBurned()) {
			System.out.println("You have recovered from your burn from the wyvern.");
			setBurned ( ); //unburn the player
		}
		
		if(r.nextInt(10000) < 1000) { //chance of missing
			System.out.println("The Player missed!");
		}else if(m.getHealth ( ) > 0 && !checkFroze()) { //if the monster is still alive from last turn just as added debugging, and also check for freeze (player)
			System.out.println("The player hits for " + playerDamage);
			m.setHealth (m.getHealth ( ) - playerDamage ); //damage calculation player -> monster
			System.out.println("The " + m.getName() + " now has " + m.getHealth ( ) + " HP");
			if(m.getHealth ( ) > 0) {
				if(w instanceof pistols) { //the pistols allow you to attack twice at less damage, just a little fun I had with the program
					System.out.println("The " + m.getName() + " is getting hit again by the player!\n" + 
										"The " + m.getName() + " gets hit for another " + playerDamage	);
				m.setHealth(m.getHealth() - playerDamage); //damage taken out by the second hit of the pistols
				System.out.println ("The " + m.getName() + " now has " + m.getHealth ( ) + " HP" );
				}
				if(w instanceof magicSword) { //magic sword check
					if(((magicSword) w).getElement ( ).equals ( "ice")) { //if you chose ice magic
						if(r.nextInt(10000) < 2000) { //chance of freezing the monster
							System.out.println("You froze the " + m.getName() + " with Ice magic from the sword!");
							m.setFroze ( ); //sets monster to frozen
						}
					}
					if(((magicSword) w).getElement( ).equals ( "fire" )) { //if you chose fire magic
						if(r.nextInt(10000) < 2000) { //chance of setting monster on fire
							System.out.println("You set the " + m.getName() + " on fire with Fire magic from the sword!");
							m.setBurning ( ); //sets monster to burned
						}
					}
					if(((magicSword) w).getElement( ).equals ( "lightning" )) { //if you chose lightning magic
						if(r.nextInt(10000) < 2000) { //chance of hitting the monster with lightning bolt
							System.out.println("A lightning bolt drops from the sky on the " + m.getName ( ) + " for " + "5 extra damage");
							m.setHealth (m.getHealth ( ) - 5); //extra damage from lightning bolt
							System.out.println("The " + m.getName() + " now has " + m.getHealth ( ) + " HP");
						}
					}
				
				}
			}
		} else {
			System.out.println("You're frozen and can't attack!"); //if frozen
		}
		if(!m.checkFroze ( ) && m.getHealth ( ) > 0) { //checks if frozen (monster)  and monster still alive, 
			if(r.nextInt(10000) < 2000) { //chance to miss
				System.out.println("The " + m.getName() + " missed!");
			}else {
				if(m instanceof undeadSoldier) { //check for undead Soldier
					if(r.nextInt(10000) < 3000) { //chance to heal instead of attack
						System.out.println("The undead Soldier healed himself for 5 HP");
						((undeadSoldier) m).heal ( ); //heals for 5 points of HP
						healed = true; //boolean flipper to prevent him from attacking and healing in the same turn
						System.out.println("The undead soldier now has " + m.getHealth() + " HP");
					}
				}
				if(m instanceof wyvern) {
					if(r.nextInt(10000) < 3000) { //chance for the wyvern to heal itself
						System.out.println("The wyvern healed himself for 12 HP");
						((wyvern) m).heal ( ); //wyvern heals for 12 points of HP
						healed = true; //boolean flipper to prevent him from attacking and healing in the same turn
						System.out.println("The wyvern now has " + m.getHealth() + " HP");
					}
				}
				if(m instanceof wyvern && !healed) { //if he didn't heal, he has a chance to use magic breath, 
					if(r.nextInt(10000) < 4000) { //40% chance of hitting with magic breath
						System.out.println("The wyvern is using his magic breath!");
						monsterDamage = ((wyvern) m).magicBreath ( ); //magic breath damage varies based on element
						if(((wyvern) m).getElement ( ).equals ( "ice")) { //if its ice
							System.out.println("The wyvern hit you with a beam of icy magic!");
							setHealth(getHealth() - monsterDamage); //hits you with ice beam
							System.out.println("You now have " + getHealth() + " HP");
							if(r.nextInt(10000) < 3500) { //chance for ice beam to freeze player
								System.out.println("The wyvern froze you with Ice magic!");
								setFroze ( ); //freezes the player
							}
						}
						if(((wyvern) m).getElement( ).equals ( "fire" )) { //if its fire
							System.out.println("The wyvern hit you with a fireball!");
							setHealth(getHealth() - monsterDamage); //hits you with fireball
							System.out.println("You now have " + getHealth() + " HP");
							if(r.nextInt(10000) < 3500) { //chance to set you on fire
								System.out.println("The wyvern set you on fire with Fire magic!");
								setBurned ( ); //set on fire or burned
							}
						}
						if(((wyvern) m).getElement( ).equals ( "lightning" )) { //if its lightning
							System.out.println("The wyvern shot you with a lightning bolt");
							setHealth(getHealth() - monsterDamage); //lightning bolts strikes initially
							System.out.println("You now have " + getHealth() + " HP");
							if(r.nextInt(10000) < 3500) { //lightning bolt has a chance to strike again
								System.out.println("The wyvern's lightning bolt struck again!");
								setHealth (getHealth ( ) - 5); //does an extra 5 points of damage
								System.out.println("You now have " + getHealth ( ) + " HP");
							}
						}	
					}
				}
				if(!healed && !magicBreath) {// this is just for the wyvern and undead soldier, but basically if either is true, it won't go forward and attack
					if(w instanceof shield) { //check to see if you have shield equipped
						health = health - (monsterDamage - 2); //blocks two points of damage from monster
						System.out.println("The " + m.getName() + " hits for " + (monsterDamage - 2));
						System.out.println("You now have " + getHealth() + " HP");
					}else{
						System.out.println("The " + m.getName() + " hits for " + monsterDamage); //otherwise get hit normally if they didn't miss
						health = health - monsterDamage; //gets hit 
						System.out.println("You now have " + getHealth() + " HP");
					}
				}else if(!healed) { //just a little confirmation they're not going to attack
					System.out.println("The " + m.getName() + " healed this turn");
				}
			}
			if(getHealth() <= 0) { //checks to see if player has died, prints game over and exits using system.exit(0)
				System.out.println("Game Over");
				System.exit (0);
			}
		}else if(m.checkFroze()){ //user confirmation for being frozen
			System.out.println("The monster is frozen. He can't move!");
		}
		if(m.getHealth ( ) <= 0) { // checks to see if the monster is dead
			System.out.println("The " + m.getName() + " is dead.");
			b = false; //sets boolean checking to see if it is alive or dead to dead
		}
		return b; //return b for main program or driver
	}
}
