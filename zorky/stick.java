/**
 * ---------------------------------------------------------------------------
 * File name: stick.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * stick is the weakest weapon in the game, but it is still pretty stout
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class stick extends weapon
{

	/**
	 * initializes the stick to basic damage of 1 and name to stick        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public stick ( )
	{
		// TODO Auto-generated constructor stub
		this.setDamageBuff (1);
		this.setDurability (10);
		this.setWeaponName ("Stick");
	}

}
