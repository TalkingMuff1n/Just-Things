/**
 * ---------------------------------------------------------------------------
 * File name: weapon.java
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
 * weapon base class, parent class to all the weapons in the game
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class weapon
{
	private int damageBuff;
	private int durability;
	private String weaponName;
	
	
	/**
	 * damage set to 1, weapon name is blank, because this is like an interface class        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * 
	 */
	public weapon() {
		damageBuff = 1;
		durability = 20;
		weaponName = "";
	}
	
	/**
	 * returns the damage buff of the weapon         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getDamageBuff() {
		return damageBuff;
	}
	
	/**
	 * not used in this program, but could used in the future        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int getDurability() {
		return durability;
	}
	
	/**
	 * used for construction of other weapons to set the damage         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param newDamage
	 */
	public void setDamageBuff(int newDamage) {
		this.damageBuff = newDamage;
	}
	
	/**
	 * used to set the durability, but again, not used in this program         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param newDura
	 */
	public void setDurability(int newDura) {
		this.durability = newDura;
	}
	
	/**
	 * used in construction to set weapon names         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param weaponName
	 */
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	
	/**
	 * basic to String, just simply returns the name of the weapon         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return weaponName;
	}
}
