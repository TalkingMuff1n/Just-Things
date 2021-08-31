/**
 * ---------------------------------------------------------------------------
 * File name: fireSword.java
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
 * magic sword class, little complicated, but not bad
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class magicSword extends weapon
{
	
	private String element;

	/**
	 * basically all it does it set the name of the sword        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public magicSword ( )
	{
		// TODO Auto-generated constructor stub
		this.setWeaponName ("Magic Sword");
		

	}
	
	/**
	 * returns the element string variable         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public String getElement() {
		return element;
	}
	
	/**
	 * sets the element to fire, also takes care of damage         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void setElementFire() {
		element = "fire";
		this.setDamageBuff (1);
		this.setDurability (50);
	}
	
	/**
	 * sets the element to ice, also takes care of damage         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void setElementIce() {
		element = "ice";
		this.setDamageBuff (3);
		this.setDurability (50);
	}
	
	
	/**
	 * sets the element to lightning, also takes care of damage         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void setElementLightning() {
		element = "lightning";
		this.setDamageBuff (2);
		this.setDurability (50);
	}
}
