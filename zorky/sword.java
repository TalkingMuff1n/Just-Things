/**
 * ---------------------------------------------------------------------------
 * File name: sword.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * sword, midrange weapon, that basically attacks for midrange damage
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class sword extends weapon
{

	/**
	 * sets damage to 3, and name to sword,         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public sword ( )
	{
		// TODO Auto-generated constructor stub
		super();
		this.setDamageBuff (3);
		this.setDurability (15);
		this.setWeaponName ("Sword");
	}

}
