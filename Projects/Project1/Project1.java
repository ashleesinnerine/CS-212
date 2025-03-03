/**
 * @author Ashlee Sinnerine
 * CSCI 212 -111C
 * Lab [34440]
 * 
 * A program that uses a GUI to run a word game
 * where the user uses the letters provided to 
 * create words of at least 5 letters long.
 */
import javax.swing.*;

public class Project1 {
	
	public static String inFileName = "P1input.txt";
	public static String letters;
	public static String[] solutions = new String[100];
	public static String inputWord;
	public static int totalSolutions = 0;
	
	public static void main(String[] args) {
		
		readinputFromFile(inFileName);
		new PuzzleGUI(letters);	
		
		while (true) {								// repeats until user enters "STOP" or exits program
			
			inputWord = JOptionPane.showInputDialog(null, 
					"Use the letters " + letters.toUpperCase() + " to create words of at least 5 letters: ");
			
			if (inputWord.equalsIgnoreCase("STOP")) {
				System.exit(0);
			}										// if the user enters "STOP", the program terminates
			
			if (wordIsThere(inputWord, solutions, totalSolutions)) 
				PuzzleGUI.displayAns(inputWord);	// displays correct words entered by user in the GUI
			else if (wrongLettersUsed(inputWord, letters)) {
				JOptionPane.showMessageDialog(null, "You used a letter that is not one of the seven letters.");
			}										// displays if the user used at least one wrong letter
			else if (inputWord.length() < 5) {
				JOptionPane.showMessageDialog(null, "Your guess is less than 5 letters long.");
			}										// displays if the user entered a word too short
			else
				JOptionPane.showMessageDialog(null, "Your guess is not on the list.");
		}											// displays if none of the if statements are true
			
	} // main

	/**
	 * Checks if user input is in the array of solutions
	 * 
	 * @param findMe The user input
	 * @param theList The array of solutions
	 * @param counter The number of solutions
	 * @return true if user input is on the solution list
	 * @return false if user input is not on the solution list
	 * 
	 */
	public static boolean wordIsThere(String findMe, String[] theList, int counter) {
		for (int i=0; i < counter; i++) {
			if (findMe.equalsIgnoreCase(theList[i])) {
				return true;
			}			
		}
		return false;
	} // wordIsThere

	/**
	 * Checks if each letter in the user input 
	 * is one of seven given letters
	 * 
	 * @param userInput The word the user entered
	 * @param theLetters The seven given letters the user can use
	 * @return true if the user used at least one wrong letter
	 * @return false if the user used only the given letters
	 */
	public static boolean wrongLettersUsed(String userInput, String theLetters) {
		int correctLetters = 0;
		for (int i=0; i < userInput.length(); i++) 
			for (int j=0; j < theLetters.length(); j++)
				if (Character.toLowerCase(userInput.charAt(i)) == Character.toLowerCase(theLetters.charAt(j))) 
					correctLetters++;
		
		if (correctLetters != userInput.length()) {
			return true;						// user used at least one wrong letter
		}
		else return false;						// user used the correct letters
	} // wrongLettersUsed
	
	/**
	 * Reads the .txt file, sets the first line to the letters the user must use,
	 * sets the remaining lines to an array of solutions to later be compared to user input,
	 * counts how many solutions are provided in the input file
	 * 
	 * @param fileName name of the file of solutions
	 * @return string the first line of letters the user must use
	 * @return string[] an array of solutions to later be compared to user input
	 * @return int the number of solutions provided in the input file
	 */
	public static void readinputFromFile(String fileName){	
		TextFileInput myFile = new TextFileInput(fileName);
		String line = myFile.readLine();
		
		letters = line; 						// sets the first line in the file to letters
		
		while (totalSolutions < solutions.length && line != null) {
			line = myFile.readLine();			// reads each line in the file
			solutions[totalSolutions]=line;		// stores the solutions in an array
			totalSolutions++;					// counts how many solutions are in the input file
		} // while
		
		if (line != null) {
			System.out.println("File contains too many solutions. ");
			System.out.println("This program can process only " + solutions.length + " solutions.");
			System.exit(1);
		} // if

	} // method readinputFromFile
	
} // class Project1
