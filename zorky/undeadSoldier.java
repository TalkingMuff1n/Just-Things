/**
 * ---------------------------------------------------------------------------
 * File name: undeadSoldier.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class undeadSoldier extends monster
{

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public undeadSoldier ( )
	{
		// TODO Auto-generated constructor stub
		super();
		this.setDamage (6);
		this.setHealth(30);
		this.setName ("Undead Soldier");
		this.setHealAmount (5);
	}
	
	public void heal() {
		this.setHealth (this.getHealth() + 5);
	}
	
	public int healAmount() {
		return 5;
	}

}
