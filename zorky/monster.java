/**
 * ---------------------------------------------------------------------------
 * File name: monster.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;

import java.util.Random;


/**
 * monster class, the villains of the game!
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class monster
{
	private int health;
	private int damage;
	private String name;
	boolean froze;
	boolean burning;
	private int healAmount;
	
	
	/**
	 * Basic constructor, this class is almost like an interface or something because it is never used, but has attributes and methods that are passed to all
	 * monster and are used throughout the program        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * 
	 */
	public monster(){
		health = 20;
		damage = 4;
		froze = false;
		burning = false;
		healAmount = 0;
	}
	
	/**
	 * returns health         
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
	 * sets the health attribute         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param newHealth
	 */
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	/**
	 * returns damage, more of a debugging thing         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * calculates damage to be dealt         
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
	 * sets the damage, more of a constructor need for the child classes         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param newDam
	 */
	public void setDamage(int newDam) {
		this.damage = newDam;
	}
	
	/**
	 * sets name, more of a constructor thing         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns name, used for user interaction         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * used for freezing         
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
	 * used to check if frozen         
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
	 * flips burning back and forth         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void setBurning() {
		burning = !burning;
	}
	
	/**
	 * returns burning true or false         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public boolean checkBurning() {
		return burning;
	}
	
	/**
	 * returns heal amount, I think i ended up not using this, but could be used for debugging or expanding         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getHealAmount() {
		return healAmount;
	}
	
	/**
	 * sets the heal amount, but again, not really used since I hardcoded the stuff in for healing, but could be for expansion or revisiting         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param ha
	 */
	public void setHealAmount(int ha) {
		healAmount = ha;
	}
}
