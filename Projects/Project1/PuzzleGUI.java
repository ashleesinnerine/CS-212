/**
 * A program that creates and edits a GUI to display the word game.
 */
import javax.swing.*;
import java.awt.*;

public class PuzzleGUI {
	
	static JFrame myFrame;
	static Container cPane;
	static TextArea puzzleLetters, wordsFound; 
	static int score = 0;
	
	/**
	 * Creates a GUI with one row and two columns
	 * and displays the seven given letters the user must use
	 * 
	 * @param letters the seven given letters the user must use
	 */
	public PuzzleGUI( String letters) {	
		initializeGUI();
		displayLetters(letters);
	}
	
	/**
	 * Creates a JFrame or GUI titled Word Game
	 * with one row and two columns,
	 * adds beginning text to both columns
	 */
	public static void initializeGUI() {
		
		puzzleLetters = new TextArea();
		wordsFound = new TextArea();
		  
	    myFrame=new JFrame();
	    myFrame.setSize(400,400);
	    myFrame.setLocation(200, 200);
	    myFrame.setTitle("Word Game");
	    myFrame.setLayout(new GridLayout(1,2));		// sets the layout to one row and two columns
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    // adds a text area to each column so we can display words
	    cPane = myFrame.getContentPane();
		myFrame.add(puzzleLetters);
		myFrame.add(wordsFound);
		  
		// displays words in each text area
		puzzleLetters.append("Letters to use: \n");
		wordsFound.append("Score: \t" + " Words found: \n");
		  
		// Display the window
		myFrame.pack();
		myFrame.setVisible(true);
	} // method initializeGUI

	/**
	 * Displays the seven given letters 
	 * in the left column in all uppercase
	 * 
	 * @param allLetters the seven given letters the user must use
	 */
	public static void displayLetters(String allLetters) {
		puzzleLetters.append(allLetters.toUpperCase());
	} // method displayLetters
	
	/**
	 * Displays each correct answer the user enters
	 * in the right column in all lowercase
	 * and displays the player's score
	 * 
	 * @param userAns the user input
	 * @return int the current score of the player
	 */
	public static void displayAns(String userAns) {
		score++;
		wordsFound.append(Integer.toString(score) + "\t" + userAns.toLowerCase() + "\n");		   
	} // method displayAns
	   
}
