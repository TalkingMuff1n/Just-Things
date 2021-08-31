/**
 * ---------------------------------------------------------------------------
 * File name: about.java
 * Project name: Project 6 CSCI 1260
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: May 1, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import java.awt.BorderLayout; //all the imports! Maybe only a few though :)
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is just the small about window, I derived it from a JFrame class, and modified it a little to make
 * it fit the needs for this project
 *
 * <hr>
 * Date created: May 1, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class about extends JFrame
{
	final int WINDOW_WIDTH = 900,
			  WINDOW_HEIGHT = 450;
	
	JPanel panelA = new JPanel();
	JPanel panelB = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelD = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelF = new JPanel();
	JPanel panelG = new JPanel();
	JPanel panelH = new JPanel();
	JLabel photoDisplayLabel2 = new JLabel();
	JLabel aboutWindowLabel = new JLabel();
	JLabel aboutWindowLabel2 = new JLabel();
	JLabel aboutWindowLabel3 = new JLabel();
	JLabel aboutWindowLabel4 = new JLabel();
	JLabel aboutWindowLabel5 = new JLabel();
	JLabel aboutWindowLabel6 = new JLabel();
	
	
	/**
	 * This is the simple constructor that makes everything work! Very similar to how I set up
	 * the clubmanagerGUI window, just this one doesn't have any buttons or listeners!        
	 *
	 * <hr>
	 * Date created: May 1, 2021 
	 *
	 * 
	 */
	about() {
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
		this.setVisible (true);
		this.setTitle ("Club Manager GUI");
		setupWindow();
		setLayout(new BorderLayout(5,5));
		add(panelA, BorderLayout.SOUTH);
		add(panelF, BorderLayout.NORTH);
		add(panelD, BorderLayout.CENTER);
	}
	
	/**
	 * Simple method called by the constructor to set up the entire window, so I didn't have to type it all
	 * out in the.. constructor         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	private void setupWindow() {
		
		aboutWindowLabel.setText ("This program was made by Dr. Bailes.");
		aboutWindowLabel5.setText ("The GUI Implementation was Instructed by Erin. L. Cook.");
		aboutWindowLabel6.setText ("It was Implemented by Josiah Truelove");
		aboutWindowLabel2.setText ("Last Revised:\t\t05/01/2021");
		aboutWindowLabel3.setText ("Author:\t\t\tJosiah Truelove");
		aboutWindowLabel4.setText ("Assignment:\t\t\tProject 6 CSCI1260-940");
		panelC.add (aboutWindowLabel);
		panelC.add (aboutWindowLabel5);
		panelC.add (aboutWindowLabel6);
		panelD.add (panelC);
		panelE.add (aboutWindowLabel2);
		panelE.add (aboutWindowLabel3);
		panelE.add (aboutWindowLabel4);
		panelF.add (panelE);
		photoDisplayLabel2.setIcon (getPhotoIcon("Welcome to the Club.jpg", 200));
		panelB.add(photoDisplayLabel2);
		panelA.add (panelB);
		
	}
	
	
	
	/**
	 * code provided to us to modify a picture, I just pasted it here even though it's public, I
	 * like to look at the code to see how it works and what not         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 * @param fileName
	 * @param desiredHeight
	 * @return
	 */
	public ImageIcon getPhotoIcon (String fileName, int desiredHeight) {
		ImageIcon icon = new ImageIcon("Pictures\\" + fileName);
		
		Image pic = icon.getImage ( );
		double ratio = (double) pic.getWidth (null)/pic.getHeight (null);
		
		BufferedImage b1 = new BufferedImage ((int) (desiredHeight * ratio), desiredHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g1 = b1.getGraphics();
		
		g1.drawImage (pic, 0, 0, (int) (desiredHeight * ratio), desiredHeight, null);
		return new ImageIcon(b1);
		
	}
}
