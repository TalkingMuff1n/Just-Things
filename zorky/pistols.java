/**
 * ---------------------------------------------------------------------------
 * File name: pistols.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * pistols weapon class, it is basically functional because of the initiateCombat() method in the player class
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class pistols extends weapon
{
	

	/**
	 * basically a constructor that just gives it its' damage, notice the damage is -1, which is added or subtracted from total damage, so it works out
	 * durability is not used in this build        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public pistols ( )
	{
		// TODO Auto-generated constructor stub
		this.setDamageBuff (-1);
		this.setDurability (30);
		this.setWeaponName ("Pistols");
	}

}
