/**
 * ---------------------------------------------------------------------------
 * File name: wyvern.java
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
 * Wyvern, the final boss, and strongest
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class wyvern extends monster
{
	private String element;
	/**
	 * initializes the standard health, and standard damage, sets name, sets healamount (which isn't used)       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public wyvern ( )
	{
		// TODO Auto-generated constructor stub
		super();
		this.setHealth (55);
		this.setDamage (8);
		this.setName ("Wyvern");
		this.setHealAmount (12);
	}
	
	/**
	 * heals the wyvern by 12 points of HP         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public void heal() {
		this.setHealth (this.getHealth ( ) + 12); 
	}
	
	
	
	/**
	 * attack that either does fire, ice or lightning damage, each with their own damage, requires for default, so if it happens to break in code (been tested 
	 * pretty well) if it happens to break, hyper beam comes out of nowhere         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int magicBreath() {
		Random r = new Random();
		int switcher = r.nextInt(3) + 1;
		switch(switcher) {
			case 1:
				element = "fire";
				return 6;
			case 2:
				element = "ice";
				return 4;
			case 3:
				element = "lightning";
				return 6;
			default:
				element = "hyper beam";
				return 20;
		}
		
	}
	
	/**
	 * returns element         
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

}
