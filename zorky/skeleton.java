/**
 * ---------------------------------------------------------------------------
 * File name: skeleton.java
 * Project name: Project 5
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package zorky;


/**
 * weakest enemy in the game, the skeleton
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class skeleton extends monster
{

	/**
	 * initializes a skeleton with damage of 4 and health of 15        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 */
	public skeleton ( )
	{
		// TODO Auto-generated constructor stub
		super();
		this.setDamage (4);
		this.setHealth (15);
		this.setName ("Skeleton");
	}

}
