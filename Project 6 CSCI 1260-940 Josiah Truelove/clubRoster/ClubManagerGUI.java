/**
 * ---------------------------------------------------------------------------
 * File name: ClubManagerGUI.java
 * Project name: Project 6 CSCI 1260
 * ---------------------------------------------------------------------------
 * Creator's name and email: Josiah Truelove, truelovejm@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 29, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import java.awt.BorderLayout; //all the imports! (also as a side note, I tried using the java.awt.*; and javax.swing.*; and they weren't cutting it so I started doing Ctrl+shift+O
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This is the GUI Class! Yay! We're done with the semester! YAAAASSS! Anyway, the basic purpose of this
 * class is to implement a GUI or a Graphical User Interface with a lot of User Friendliness
 * GUI is also a way that you can in a lot of ways keep the user from breaking your program
 * I went pretty in depth in this one to make it close to unbreakable, but I am running out of time
 * for this project and there are still a few bugs. I have left one or two of the bugs in because they
 * were getting a bit out of the scope of what I wanted to accomplish with this class, but I hope I will
 * one day return to this GUI and make it unbreakable, even a potato could use it, ya know? Anyway
 * the rest of the commenting is done thoughout the file, have fun reading it! 
 *
 * <hr>
 * Date created: Apr 29, 2021
 * <hr>
 * @author Josiah Truelove
 */
public class ClubManagerGUI extends JFrame
{
	
	//this is all the stuff I ended up using for my GUI Window, lot of stuff for such a simple window!
	final int WINDOW_WIDTH = 800,
			  WINDOW_HEIGHT = 900;
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	JPanel panel9 = new JPanel();
	JPanel panel10 = new JPanel();
	JPanel panel11 = new JPanel();
	JPanel panel12 = new JPanel();
	JPanel panel13 = new JPanel();
	JPanel panel14 = new JPanel();
	JPanel panel15 = new JPanel();
	JPanel panel16 = new JPanel();
	JPanel panel17 = new JPanel();
	JPanel panel18 = new JPanel();
	JPanel panel19 = new JPanel();
	JPanel panel20 = new JPanel();
	JPanel panel21 = new JPanel();
	JPanel panel22 = new JPanel();
	JPanel panel23 = new JPanel();
	JPanel panel24 = new JPanel();
	JPanel panel25 = new JPanel();
	JPanel panel26 = new JPanel();
	JPanel panel27 = new JPanel();
	JPanel panel28 = new JPanel();
	JPanel panel29 = new JPanel();
	JPanel panel30 = new JPanel();
	JPanel panel31 = new JPanel();
	JMenuBar clubMenuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem createItem = null;
	JMenuItem openItem = null;
	JMenuItem saveItem = null;
	JMenuItem exitItem = null;
	JMenu editMenu = new JMenu("Edit");
	JMenuItem addItem = null;
	JMenuItem modifyItem = null;
	JMenuItem dropItem = null;
	JMenu helpMenu = new JMenu("Help");
	JMenuItem aboutItem = null;
	JLabel jListLabel = new JLabel("Member Names");
	JTextField clubName = new JTextField();
	JLabel cnLabel = new JLabel("Club Name");
	JTextField clubLeader = new JTextField();
	JLabel clLabel = new JLabel("Club Leader");
	JTextField clubYear = new JTextField();
	JLabel cyLabel = new JLabel("Year Founded");
	JTextField firstName = new JTextField();
	JLabel fnLabel = new JLabel("First Name");
	JTextField lastName = new JTextField();
	JLabel lnLabel = new JLabel("Last Name");
	JTextField city = new JTextField();
	JLabel cLabel = new JLabel("City");
	JTextField state = new JTextField();
	JLabel sLabel = new JLabel("State");
	JTextField dateJoined = new JTextField();
	JLabel dLabel = new JLabel("Date Joined");
	JTextField photo = new JTextField();
	JLabel pLabel = new JLabel("Photo Path");
	JLabel tLabel = new JLabel("Member Type");
	JButton addMember = new JButton("Add");
	JButton dropMember = new JButton("Drop");
	JButton editMember = new JButton("Save Changes to Member");
	JButton refresh = new JButton("Refresh");
	JButton saveClubInfo = new JButton("Save Club Info");
	JComboBox<String> type = null;
	ImageIcon photoDisplay = new ImageIcon("Pictures\\Me and Grandmother.JPG");
	JLabel photoDisplayLabel = new JLabel();
	String array[] = null;
	Club clay = new Club();
	JList<String> memberList = new JList<String>();
	JScrollPane memberScroll = new JScrollPane(memberList);
	ArrayList<Member> memberArrayList = null;
	Member somebody = null;
	int memberListIndex = 0;
	
	
	
	
	/**
	 * This is where the magic happens in all reality. Without this constructor, nothing in the program
	 * would work, because it is not a.. per se.. moving program, it's all 'still-framed' and reacts
	 * to whatever the user does in the driver, which where this window is implemented       
	 *
	 * <hr>
	 * Date created: May 1, 2021 
	 *
	 * 
	 */
	ClubManagerGUI(){
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setVisible (true);
		this.setTitle ("Club Manager GUI");
		setupMainMenu();
		setupPanel1();
		setupPanel2();
		setupPanel3();
		setIcon();
		setLayout(new BorderLayout(5,5));
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.EAST);
		add(panel3, BorderLayout.SOUTH);
	}
	
	/**
	 * This is the main menu (or the menu bar at the top of the window) it has all the functionality
	 * required, and nothing more, I hope you like it!         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	private void setupMainMenu() {
		
		
			//set up File Menu
			createItem = new JMenuItem("Create a New Club");
			createItem.addActionListener (new createNewClubListener());
			openItem = new JMenuItem("Open a Club Roster");
			openItem.addActionListener (new openClubListener());
			saveItem = new JMenuItem("Save Current Club Roster");
			saveItem.addActionListener (new saveClubListener());
			exitItem = new JMenuItem("Exit Club Manager");
			exitItem.addActionListener (new exitClubListener());
			fileMenu.add (createItem);
			fileMenu.add (openItem);
			fileMenu.add (saveItem);
			fileMenu.add (new JSeparator());
			fileMenu.add (exitItem);
			clubMenuBar.add (fileMenu);
			
			//set up Edit Menu
			addItem = new JMenuItem("Add a Member to the Club");
			addItem.addActionListener (new addMemberButtonListener());
			modifyItem = new JMenuItem("Modify Member Data");
			modifyItem.addActionListener (new editMemberButtonListener());
			dropItem = new JMenuItem("Drop a Member from the Club");
			dropItem.addActionListener (new dropMemberButtonListener());
			editMenu.add (addItem);
			editMenu.add (modifyItem);
			editMenu.add (dropItem);
			clubMenuBar.add(editMenu);
			
			//set up help menu
			aboutItem = new JMenuItem("About");
			aboutItem.addActionListener(new aboutClubListener());
			helpMenu.add (aboutItem);
			clubMenuBar.add (helpMenu);
			
			this.setJMenuBar(clubMenuBar);
		
	}
	
	/**
	 * This is panel 1, which is basically just the Jlist and the Jscrolpane, which simply put, is the
	 * entire essence of panel 1         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	private void setupPanel1() {
		memberList.setFixedCellWidth(275);
		memberList.setFixedCellHeight (25);
		memberList.addListSelectionListener (new selectMember());
		memberList.setVisibleRowCount (10);
		panel1.add (memberScroll);
	}
	
	/**
	 * This is panel 2, which was created using a grid layout, instead of a border layout which was
	 * used for the rest of the program, I found it easier to get the buttons where I wanted
	 * them to go in the grid layout         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	private void setupPanel2() {
		panel2.setLayout (new GridLayout(13, 2));;
		//panel2.add (tLabel);
		type = new JComboBox(MemberType.values());
		type.setPreferredSize (new Dimension(200,25));
		//panel2.add (type);
		panel4.add (tLabel);
		panel5.add (type);
		panel6.add (fnLabel);
		panel7.add (firstName);
		panel8.add (lnLabel);
		panel9.add (lastName);
		panel10.add (cLabel);
		panel11.add (city);
		panel12.add (sLabel);
		panel13.add (state);
		panel14.add (dLabel);
		panel15.add (dateJoined);
		panel16.add (pLabel);
		panel17.add (photo);
		panel18.add (cnLabel);
		panel19.add (clubName);
		panel20.add (clLabel);
		panel21.add (clubLeader);
		panel22.add (cyLabel);
		clubYear.setText ("1900");
		panel23.add (clubYear);
		panel24.add (addMember);
		addMember.addActionListener (new addMemberButtonListener());
		panel25.add (dropMember);
		dropMember.addActionListener (new dropMemberButtonListener());
		panel26.add (refresh);
		editMember.addActionListener(new editMemberButtonListener());
		panel27.add (editMember);
		refresh.addActionListener(new refreshButtonListener());
		panel28.add (saveClubInfo);
		saveClubInfo.addActionListener (new saveClubInfoActionListener());
		firstName.setPreferredSize (new Dimension(200, 25));
		lastName.setPreferredSize (new Dimension(200,25));
		city.setPreferredSize (new Dimension(200, 25));
		state.setPreferredSize (new Dimension(200,25));
		dateJoined.setPreferredSize (new Dimension(200,25));
		photo.setPreferredSize (new Dimension(200,25));
		clubName.setPreferredSize (new Dimension(200, 25));
		clubLeader.setPreferredSize (new Dimension(200,25));
		clubYear.setPreferredSize (new Dimension(200,25));
		panel2.add (panel18);
		panel2.add (panel19);
		panel2.add (panel20);
		panel2.add (panel21);
		panel2.add (panel22);
		panel2.add (panel23);
		panel2.add (panel4);
		panel2.add (panel5);
		panel2.add (panel6);
		panel2.add (panel7);
		panel2.add (panel8);
		panel2.add (panel9);
		panel2.add (panel10);
		panel2.add (panel11);
		panel2.add (panel12);
		panel2.add (panel13);
		panel2.add (panel14);
		panel2.add (panel15);
		panel2.add (panel16);
		panel2.add (panel17);
		panel2.add (panel24);
		panel2.add (panel25);
		panel2.add (panel26);
		panel2.add (panel27);
		panel2.add (panel28);
	}
	
	/**
	 * This is panel 3, which essentially is just where the picture of the club member goes
	 * It is essentially just a photo displayer panel, everything else is done in the main menu,
	 * panel 1, and panel 2         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	private void setupPanel3(){
		photoDisplayLabel.setIcon(getPhotoIcon("Welcome to the Club.jpg", 350));
		panel3.add (photoDisplayLabel);
	}
	
	private void setIcon() {
		try {
			File file = new File("Pictures\\Colors.png");
			BufferedImage icon = ImageIO.read (file);
			setIconImage(icon);
		}catch(Exception e) {
			//Ignore Missing Icon
		}
	}
	
	/**
	 * This is the code that we were given to modify pictures that we used for (in my case panel 3)
	 * but in general the photo display of each member         
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
	
	
	
	/**
	 * Now this is a big boy, but in all reality, I used a lot of the code from the final solution of project 4
	 * and just copy and pasted it. This is really simple in how it works. It asks if you want to save
	 * the current club, if you have a club that has had changes made to it, (I thought of microsoft word
	 * when I designed the project, when you open microsoft word, there is a blank document, ready to go)
	 * so with that in mind, I made it so that as soon as the program started, there is a blank club 
	 * ready to be made. If you decide to start a new club, it uses the same window, but asks you to save
	 * and if you choose to not save, all it does it trash everything and start fresh
	 * 
	 * if you do ask it to save, it does the same thing as the save function
	 * 
	 * if you cancel, it cancels the operation and keeps the current club, if you cancel during the save
	 * it still keeps the club so that you don't lose any important information
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class createNewClubListener implements ActionListener {
		
		/**
		 * method for action listener for create new club button under main menu file menu create new club item (createItem)         
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			
			boolean saveSuccessful = false;
			
			if(clay == null) {
				
				clay = new Club();
				
				String[] array = new String[clay.getClubSize ( )];
				
				for(int i = 0; i<clay.getClubSize ( ); i++) {
					array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
				}
				
				memberList.setListData (array);
				
			}else {
			
				if(clay.isSaveNeeded ( )) {
					int choice = JOptionPane.showConfirmDialog (rootPane, "It appears that you have made changes to the current club. Would you like to save your changes?");
					if(choice == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog (rootPane, "Create new Club Operation Cancelled");
						return;
					}else if(choice == JOptionPane.YES_OPTION) {
						JFileChooser dlg = new JFileChooser ("ClubData");
						FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
						dlg.setFileFilter (filter);
						dlg.setDialogTitle ("Select the Club Data File You Wish to Save");
						int button = dlg.showSaveDialog (null);
						if (button != JFileChooser.APPROVE_OPTION)
						{
							JOptionPane.showMessageDialog (null, "No file selected", "File Not Saved",
								JOptionPane.INFORMATION_MESSAGE);
							return;
						}
	
						try
						{
							clay.saveFile (dlg.getSelectedFile ( ).getPath ( ));
							JOptionPane.showMessageDialog (null, "File saved successfully", "File Saved",
								JOptionPane.INFORMATION_MESSAGE);
							saveSuccessful = true;
							
						}
						catch (FileNotFoundException a)
						{
							JOptionPane.showMessageDialog (null, "File not found - " + a.getMessage ( ),
								"File Not Found", JOptionPane.ERROR_MESSAGE);
							a.printStackTrace ( );
						}
						catch (Exception a)
						{
							JOptionPane.showMessageDialog (null, "File not saved - " + a.getMessage ( ),
								"Error During File Save", JOptionPane.ERROR_MESSAGE);
							a.printStackTrace ( );
						}
					}else if(choice == JOptionPane.NO_OPTION) {
						
						clay = new Club();
						
						String[] array = new String[clay.getClubSize ( )];
						
						for(int i = 0; i<clay.getClubSize ( ); i++) {
							array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
						}
						
						memberList.setListData (array);
						
						clubName.setText ("");
						clubLeader.setText ("");
						clubYear.setText ("1900");
					
					}
					
					
					
					if(saveSuccessful) {
						
						
						clay = new Club();
						
						String[] array = new String[clay.getClubSize ( )];
						
						for(int i = 0; i<clay.getClubSize ( ); i++) {
							array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
						}
						
						memberList.setListData (array);
						
					}
				}
			}
			
		}
	}
	
	
	/**
	 * This is essentially the fill from file function (or actionlistener)
	 * all this does, is when you want to work with a club you have already worked on
	 * it opens it, and displays all the members yaddah yaddah, and then bam
	 * you pick up where you left off last time, 
	 * 
	 * most of this was copy and pasted from Dr. Bailes Project 4 solution
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class openClubListener implements ActionListener {
			
			/**
			 * method for action listener for open club under main menu under file menu open item         
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 * <hr>
			 * @param a
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent a) {
				
				clay = new Club ( );
				JFileChooser dlg = new JFileChooser ("ClubData");
				FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
				dlg.setFileFilter (filter);
				dlg.setDialogTitle ("Select the Club Data File You Wish to Open");
				int button = dlg.showOpenDialog (null);
				if (button != JFileChooser.APPROVE_OPTION)
				{
					JOptionPane.showMessageDialog (null, "No file selected", "File Not Opened",
						JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				try
				{
					clay.fillFromFile (dlg.getSelectedFile ( ).getPath ( ));
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog (null,
						"There was an error processing the file - operation terminated. \n" +
										e.getMessage ( ),
						"Error Reading from File", JOptionPane.ERROR_MESSAGE);
				}
				
				String[] array = new String[clay.getClubSize ( )];
				
				for(int i = 0; i<clay.getClubSize ( ); i++) {
					array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
				}
				
				memberList.setListData (array);
				
				clubName.setText (clay.getClubName ( ));
				clubLeader.setText (clay.getHead ( ));
				clubYear.setText (String.valueOf ( clay.getYear ( )));
			
		}
	}
	
	
	/**
	 * This is simply the save club listener, which reacts when of course you click the save club roster
	 * underneath the main menu bar, but of course, this is the case for the past 3 listeners I just
	 * haven't mentioned it
	 * 
	 * I copied most of this from Dr. Bailes project 4 too
	 * 
	 * don't get me wrong, i did project 4, but I decided to do Dr. Bailes project 4 version
	 * because I wanted to be spot on
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class saveClubListener implements ActionListener {
		
		/**
		 * method for action listener for save club under main menu under file menu save item         
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param e
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
		
			if (clay == null)
			{
				JOptionPane.showMessageDialog (null, "There is no club to save", "Save Failed",
					JOptionPane.ERROR_MESSAGE);
				return;
			}
			JFileChooser dlg = new JFileChooser ("ClubData");
			FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
			dlg.setFileFilter (filter);
			dlg.setDialogTitle ("Select the Club Data File You Wish to Save");
			int button = dlg.showSaveDialog (null);
			if (button != JFileChooser.APPROVE_OPTION)
			{
				JOptionPane.showMessageDialog (null, "No file selected", "File Not Saved",
					JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			try
			{
				clay.saveFile (dlg.getSelectedFile ( ).getPath ( ));
				JOptionPane.showMessageDialog (null, "File saved successfully", "File Saved",
					JOptionPane.INFORMATION_MESSAGE);
			}
			catch (FileNotFoundException a)
			{
				JOptionPane.showMessageDialog (null, "File not found - " + a.getMessage ( ),
					"File Not Found", JOptionPane.ERROR_MESSAGE);
				a.printStackTrace ( );
			}
			catch (Exception a)
			{
				JOptionPane.showMessageDialog (null, "File not saved - " + a.getMessage ( ),
					"Error During File Save", JOptionPane.ERROR_MESSAGE);
				a.printStackTrace ( );
			}
		
		}
	}

	
	/**
	 * This is the exit club listener, and of course, it is the.. how do you put it, it is simply
	 * a check to see if it has been saved yet, and if it has, then System.exit(0)
	 * it may not be the best solution, but it is my solution, which I think works well
	 * but for the time being, these are my guns and I'm sticking to 'em!
	 * 
	 * this is also partially copied from Dr. Bailes project 4, but with as the rest of these
	 * I have tweaked them in my own ways
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class exitClubListener implements ActionListener {
			
			/**
			 * method for action listener for exit club under main menu file menu for exit item         
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 * <hr>
			 * @param e
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
			
				if(clay.isSaveNeeded ( )) {
					int choice = JOptionPane.showConfirmDialog (rootPane, "It appears that you have made changes to the current club. Would you like to save your changes?");
					if(choice == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog (rootPane, "Create new Club Operation Cancelled");
						return;
					}else if(choice == JOptionPane.YES_OPTION) {
						JFileChooser dlg = new JFileChooser ("ClubData");
						FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
						dlg.setFileFilter (filter);
						dlg.setDialogTitle ("Select the Club Data File You Wish to Save");
						int button = dlg.showSaveDialog (null);
						if (button != JFileChooser.APPROVE_OPTION)
						{
							JOptionPane.showMessageDialog (null, "No file selected", "File Not Saved",
								JOptionPane.INFORMATION_MESSAGE);
							return;
						}
	
						try
						{
							clay.saveFile (dlg.getSelectedFile ( ).getPath ( ));
							JOptionPane.showMessageDialog (null, "File saved successfully", "File Saved",
								JOptionPane.INFORMATION_MESSAGE);
							
						}
						catch (FileNotFoundException a)
						{
							JOptionPane.showMessageDialog (null, "File not found - " + a.getMessage ( ),
								"File Not Found", JOptionPane.ERROR_MESSAGE);
							a.printStackTrace ( );
						}
						catch (Exception a)
						{
							JOptionPane.showMessageDialog (null, "File not saved - " + a.getMessage ( ),
								"Error During File Save", JOptionPane.ERROR_MESSAGE);
							a.printStackTrace ( );
						}
					}else if(choice == JOptionPane.NO_OPTION) {
						
						clay = new Club();
						
						String[] array = new String[clay.getClubSize ( )];
						
						for(int i = 0; i<clay.getClubSize ( ); i++) {
							array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
						}
						
						memberList.setListData (array);
						
						clubName.setText ("");
						clubLeader.setText ("");
						clubYear.setText ("1900");
					
					}
					
					System.exit (0);
			
			
				}
			}
	}
	
	
	/**
	 * This one was a little tricky, but it just basically displays the about the club page,
	 * I couldn't get the thing to render the words the way I wanted, so I just made it bigger,
	 * lol
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class aboutClubListener implements ActionListener {
			
			/**
			 * method for action listener for about club listener main menu item under help menu        
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 * <hr>
			 * @param e
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
			
				SwingUtilities.invokeLater (
					new Runnable() {
						@Override
						public void run() {
							new about();
						}
					}
								
				);
			
			}
	}
	
	
	/**
	 * This is simply the select member listener, which just basically updates all the information
	 * on the screen with whatever you have selected from the JList
	 * 
	 * This is all original, wrote this one entirely by myself (just for the record)
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class selectMember implements ListSelectionListener {
		
			/**
			 * method for list selection listener for selectmember listSelectionListener
			 * 
			 * "Woo, this one tripped me up when the rest of them are action listeners lol"
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 * <hr>
			 * @param a
			 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
			 */
			public void valueChanged(ListSelectionEvent a) {
				
				memberListIndex = memberList.getSelectedIndex ( );
				
				if(memberListIndex == -1) {
					memberListIndex = 0;
				}
				
				firstName.setText (clay.getRoster ( ).get (memberListIndex).getFirstName ( ));
				lastName.setText( clay.getRoster ( ).get (memberListIndex).getLastName ( ));
				city.setText (clay.getRoster ( ).get (memberListIndex).getCity ( ));
				state.setText (clay.getRoster ( ).get (memberListIndex).getState());
				dateJoined.setText ( clay.getRoster ( ).get (memberListIndex).getDateJoined ( ));
				photo.setText ( clay.getRoster ( ).get (memberListIndex).getPhoto());
				type.setSelectedItem (clay.getRoster ( ).get (memberListIndex).getType());
				photoDisplayLabel.setIcon(getPhotoIcon(clay.getRoster ( ).get (memberListIndex).getPhoto(), 400));
				
				clubName.setText (clay.getClubName ( ));
				clubLeader.setText (clay.getHead ( ));
				clubYear.setText (String.valueOf (clay.getYear ( )));
				
			}
	}
	
	
	/**
	 * This is essentially just the add button on the GUI's listener
	 * this takes all the information, given that you have a first and last name input
	 * and allows you to add members, some that may not have all the information for them
	 * yet, but are prospective members is what I was thinking
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class addMemberButtonListener implements ActionListener {
		
			/**
			 * method for action listener for add member button and main menu item add member         
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 * <hr>
			 * @param a
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent a) {
				
				Member clayPerson = null;
				
				String fn, ln, c, s, dj, p;
				int index;
				MemberType t;
				
				MemberType[] array2 = new MemberType[6];
				
				array2 = MemberType.values ( );
				
				
				
				t =  array2[type.getSelectedIndex ( )];
				fn = firstName.getText ( );
				ln = lastName.getText ( );
				c = city.getText ( );
				s = state.getText ( );
				dj = dateJoined.getText ( );
				p = photo.getText ( );
				
				if(fn.equals ("")) {
					JOptionPane.showMessageDialog (rootPane, "You don't have a first name for this member");
					return;
				}else if(ln.equals ("")) {
					JOptionPane.showMessageDialog (rootPane, "You don't have a last name for this member");
					return;
				}
				
				clayPerson = new Member(ln, fn, c, s, dj, p, t);
				
				clay.addMember (clayPerson);
				
				String[] array = new String[clay.getClubSize ( )];
				
				for(int i = 0; i<clay.getClubSize ( ); i++) {
					array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
				}
				
				memberList.setListData (array);
				
			}
	}
	
	
	/**
	 * This is the drop member listener, and simply drops a member! 
	 * 
	 * I tried to make it to where it was more user friendly when you clicked on something
	 * and dropped it, by instead of defaulting to having nobody selected, it chooses
	 * who is selected after someone is dropped, by determining whether or not the 
	 * list is empty, or if there is someone in front of or behind, and if those are
	 * the cases (list!=empty && (somebody+1 || somebody-1)) then it is true, that's not the
	 * precise logic, but if it can't select somewhere to put the selector in the Jlist,
	 * then it doesn't, I didn't get it fully working for when you just wanted to start from
	 * scratch, but it works
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class dropMemberButtonListener implements ActionListener {
		
		
		/**
		 * method for action listener for drop member button and main menu item drop member         
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param a
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent a) {
			
			int index = memberListIndex;
			int subIndex = memberListIndex;
			
			if(memberListIndex == -1) {
				index = 0;
				return;
			}else if(memberList.getModel().getSize() == 0) {
				JOptionPane.showMessageDialog (rootPane, "You don't have any members to drop!");
				return;
			}
			
			String name = clay.getRoster ( ).get (index).getName ( );
			
			clay.removeMember (name);
			
			
			
			String[] array = new String[clay.getClubSize ( )];
			
			for(int i = 0; i<clay.getClubSize ( ); i++) {
				array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
			}
			
			memberList.setListData (array);
			
			if(subIndex == 0 && memberList.getModel ( ).getSize() > 0) {
				
				memberList.setSelectedIndex(subIndex);
				
			}else if(memberList.getModel ( ).getSize() > 0) {
			
				memberList.setSelectedIndex (subIndex - 1);
			
			}else {
				
				return;
				
			}
			
		}
	}
	
	
	/**
	 * This is edit member listener, which is connect to the edit member JMenuItem
	 * in the main menu, but also, it is the save changes to member button on the actual
	 * window, which I thought would make it quicker for editing and using, which I think it does
	 * but that may be debatable, but I like it!
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class editMemberButtonListener implements ActionListener {
		
		/**
		 * method for action listener for edit member button and menu option         
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param a
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent a) {
			
			
			if(memberList.getModel ( ).getSize() == 0) {
				JOptionPane.showMessageDialog (rootPane, "There are no members to edit!");
			}else if(memberListIndex == -1) {
				JOptionPane.showMessageDialog (rootPane, "You must select a member first to edit!");
			}else {
				String fn, ln, c, s, dj, p;
				
				fn = firstName.getText ();
				ln = lastName.getText();
				c = city.getText ();
				s = state.getText ();
				dj = dateJoined.getText ();
				p = photo.getText ();
				
				MemberType t;
				
				MemberType[] array2 = new MemberType[6];
				
				array2 = MemberType.values ( );
				
				t =  array2[type.getSelectedIndex ( )];
				
				clay.getRoster ( ).get(memberListIndex).setFirstName (fn);
				clay.getRoster ( ).get (memberListIndex).setLastName (ln);
				clay.getRoster ( ).get (memberListIndex).setCity (c);
				clay.getRoster ( ).get (memberListIndex).setState (s);
				clay.getRoster ( ).get (memberListIndex).setDateJoined (dj);
				clay.getRoster ( ).get (memberListIndex).setPhoto (p);
				clay.getRoster ( ).get (memberListIndex).setType (t);
				
				
				String[] array = new String[clay.getClubSize ( )];
				
				for(int i = 0; i<clay.getClubSize ( ); i++) {
					array[i] = clay.getRoster ( ).get (i).getLastName ( ) + ", " + clay.getRoster ( ).get (i).getFirstName ( );
				}
				
				memberList.setListData (array);
				
				firstName.setText (clay.getRoster ( ).get (memberListIndex).getFirstName ( ));
				lastName.setText( clay.getRoster ( ).get (memberListIndex).getLastName ( ));
				city.setText (clay.getRoster ( ).get (memberListIndex).getCity ( ));
				state.setText (clay.getRoster ( ).get (memberListIndex).getState());
				dateJoined.setText ( clay.getRoster ( ).get (memberListIndex).getDateJoined ( ));
				photo.setText ( clay.getRoster ( ).get (memberListIndex).getPhoto());
				type.setSelectedItem (clay.getRoster ( ).get (memberListIndex).getType());
				photoDisplayLabel.setIcon(getPhotoIcon(clay.getRoster ( ).get (memberListIndex).getPhoto(), 400));
			
				memberList.setSelectedIndex (memberList.getModel ( ).getSize() - 1);
			}
		}
		
	}
	
	
	/**
	 * This is something I just kind of threw in for kicks and giggles, which is basically
	 * a refresh button, because personally I know that if I don't have a refresh button on..
	 * well anything, it frustrates me, so this just clears the info, clears the selection,
	 * and shows the main picture at the bottom, that's the gyst of it!
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class refreshButtonListener implements ActionListener {
		
		
		/**
		 * method for Action Listener for refresh button         
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param a
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent a) {
			
			memberListIndex = -1;
			
			if(memberList.getModel ( ).getSize() == 0 || memberListIndex == -1) {
				firstName.setText ("");
				lastName.setText ("");
				city.setText ("");
				state.setText ("");
				dateJoined.setText ("");
				photo.setText ("");
				photoDisplayLabel.setIcon (getPhotoIcon("Welcome to the Club.jpg", 350));
			}else {
				
				firstName.setText (clay.getRoster ( ).get (memberListIndex).getFirstName ( ));
				lastName.setText( clay.getRoster ( ).get (memberListIndex).getLastName ( ));
				city.setText (clay.getRoster ( ).get (memberListIndex).getCity ( ));
				state.setText (clay.getRoster ( ).get (memberListIndex).getState());
				dateJoined.setText ( clay.getRoster ( ).get (memberListIndex).getDateJoined ( ));
				photo.setText ( clay.getRoster ( ).get (memberListIndex).getPhoto());
				type.setSelectedItem (clay.getRoster ( ).get (memberListIndex).getType());
				photoDisplayLabel.setIcon(getPhotoIcon(clay.getRoster ( ).get (memberListIndex).getPhoto(), 400));
			}
			
				clubName.setText (clay.getClubName ( ));
				clubLeader.setText (clay.getHead ( ));
				clubYear.setText (String.valueOf (clay.getYear ( )));
			
		}
	}
	
	
	/**
	 * This was my solution to modifying the club info, without constantly saving the club
	 * info every time you made changes to a member, to help the user
	 * 
	 * I literally thought about it like this, if you save changes to a member every time
	 * you may not like what you get, so in other words, you may accidentally add an l or
	 * a t or some random letter, and it WILL SAVE THAT, but only if you click the save club info
	 * button on the GUI
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Josiah Truelove
	 */
	private class saveClubInfoActionListener implements ActionListener {
		
		/**
		 * method for Action Listener for save club info         
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param a
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent a) {
			
			String cn, cl, yf;
			
			cn = clubName.getText ( );
			cl = clubLeader.getText ( );
			yf = clubYear.getText ( );
			
			int yearInt = 0;
			
			boolean okay = false;
			
			try {
				yearInt = Integer.parseInt (yf);
				okay = true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog (rootPane, "That's not an integer! Club year is 4 numbers in the format YYYY for year founded");
			}
			
			if(okay) {
				clay.setYear (yearInt);
			}
			
			clay.setHead (cl);
			clay.setClubName (cn);
			
			clubName.setText (clay.getClubName ( ));
			clubLeader.setText (clay.getHead ( ));
			clubYear.setText (String.valueOf ( clay.getYear ( )));
		}
		
	}
	
	
	
	
	
	
	
}
