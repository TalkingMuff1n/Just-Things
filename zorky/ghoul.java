/**
 * ---------------------------------------------------------------------------
 * File name: ghoul.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * ghoul, midrange enemy, weaker than undead soldier, and still cannot heal
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class ghoul extends monster
{

	/**
	 * initializes the object, sets health to 25, and damage to 5, sets name to ghoul        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public ghoul ( )
	{
		// TODO Auto-generated constructor stub
		this.setHealth(25);
		this.setDamage (5);
		this.setName ("Ghoul");
	}

}
