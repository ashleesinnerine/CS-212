/*
Ashlee Sinnerine
CSCI - 212 - LAB 111C [34440]
*/

import javax.swing.*;

public class Project0 {

	public static void main(String[] args) {
		
		//uses a while loop that will repeat the program indefinitely until the user enters stop
		while (true) {
			
			//prompts user input in a dialog box and sets the input equal to the string sentence
			String sentence = JOptionPane.showInputDialog(null, "Please enter a sentence.");
			
			//checks if the user types stop
			//uses .equalsIgnoreCase to cover all upper/lower case variations of "stop"
			if (sentence.equalsIgnoreCase("stop")) {
				//terminates the program if the user enters stop
				System.exit(0);
			}
			
			//declares two integer variables to store the total amount of uppercase and lowercase characters in the user input
			int uppercase = 0, lowercase = 0;
			
			//uses a for loop to iterate through every character in the user input
			for (int i=0; i<sentence.length(); i++){
				
				//uses .charAt to check if a character in the user input in equal to 'E'
				if(sentence.charAt(i) == 'E') {
					//for every uppercase 'E' found, add 1 to the integer uppercase
					uppercase++;
				}
				
				//uses .charAt to check if a character in the user input in equal to 'e'
				if(sentence.charAt(i) == 'e') {
					//for every lowercase 'e' found, add 1 to the integer lowercase
					lowercase++;
				}
			}
			
			//display in a dialog box the number of E's and e's in the user input
			JOptionPane.showMessageDialog(null, 
					"Number of uppercase e's: " + uppercase + "\n" +
					"Number of lowercase e's: " + lowercase);
		}

	}

}
