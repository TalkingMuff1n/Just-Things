/**
 * ---------------------------------------------------------------------------
 * File name: shield.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * shield class, used to block damage
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class shield extends weapon
{
	
	private int block;
	
	/**
	 * basic constructor for shield class, nothing special leaving the block attribute in case I want to expand with different types of shields        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public shield ( )
	{
		// TODO Auto-generated constructor stub
		super();
		this.setDamageBuff (0);
		this.setDurability (20);
		this.setWeaponName ("Shield");
		block = 2;
	}

}
