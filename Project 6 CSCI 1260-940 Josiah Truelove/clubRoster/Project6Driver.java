/**
 * ---------------------------------------------------------------------------
 * File name: Project4Driver.java Project name: Project 4 - Club Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu Course: CSCI 1260
 * Creation Date: Oct 19, 2015
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import javax.swing.*;


/**
 * Driver, starts the GUI application
 *
 * <hr>
 * Date created: Oct 19, 2015
 * <hr>
 * 
 * @author Josiah Truelove
 */
public class Project6Driver
{

	/**
	 * This is my project 6 driver or main method, it opens the program!
	 *
	 * <hr>
	 * Date created: Oct 19, 2015
	 *
	 * <hr>
	 * 
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		
		SwingUtilities.invokeLater (
			new Runnable() {
				@Override
				public void run() {
					new ClubManagerGUI();
				}
			}
						
		);
	}

	
}
