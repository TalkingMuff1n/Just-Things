/**
 * ---------------------------------------------------------------------------
 * File name: inventory.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 17, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;

import java.util.ArrayList;


/**
 * inventory class - I was really going for object-oriented programming, but in all reality, I probably could have had this inside the player class
 * but I decided to go ahead and use this class since I had already coded it
 *
 * <hr>
 * Date created: Apr 17, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class inventory
{
	private ArrayList<weapon> weapons;
	private int elixirs;
	
	
	/**
	 * basic initilization constructor, starts with 3 elixirs        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * 
	 */
	public inventory(){
		elixirs = 3;
		weapons = new ArrayList<weapon>();
	}
	
	/**
	 * adds a weapon to weapons arraylist         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param w
	 */
	public void addWeapon(weapon w) {
		weapons.add (w);
	}
	
	/**
	 * never used, in an earlier version of the game, I was going to have durability on the weapons and have the weapons break after too many uses,
	 * leaving this in in case I ever want to revisit it         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param index
	 */
	public void destroyWeapon(int index) {
		weapons.remove (index);
	}
	
	/**
	 * method to drink elixir, really doesn't effect the player here besides the number in inventory         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void drinkElixir() {
		if(elixirs > 0) {
			elixirs--;
		}else {
			System.out.println("You don't have any elixirs!");
		}
	}
	
	/**
	 * used for picking up elixirs         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void addElixir() {
		elixirs++;
	}
	
	/**
	 * used to return a weapon by index, but it is used to equip a weapon basically         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param index
	 * @return
	 */
	public weapon getWeapon(int index) {
		return weapons.get(index);
	}
	
	/**
	 * lays out all the weapons, used in conjunction with checkWeapons() method in player         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void weaponsOut() {
		for(int i = 0; i<weapons.size ( ); i++) {
			System.out.println(i + ". " + weapons.get (i));
		}
	}
	
	/**
	 * returns number of elixirs         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int checkElixirs() {
		return elixirs;
	}
	
	/**
	 * used in conjunction with checkInventory() basically a toString()         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String inventoryString = "";
		inventoryString += "Weapons:\n";
		for (int i = 0; i<weapons.size ( ); i++) {
			inventoryString += i + ". " + weapons.get (i).toString ( ) + "\n";
		}
		inventoryString += "Elixirs:\n" + elixirs;
		
		return inventoryString;
	}
}
