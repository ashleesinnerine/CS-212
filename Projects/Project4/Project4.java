// Project4.java

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.*;

/**
 * A program that reads from a file and
 * displays to the console all the words
 * in the file in alphabetical order
 * along with the number of times each
 * word appeared in the file.
 * 
 * @author Ashlee Sinnerine
 * @version 5/15/2024
 * CSCI 212
 * Lab 111C [34440]
 */
public class Project4 {
	
	/**
	 * The main method of the program.
	 * 
	 * @param args command line arguments.
	 */
    public static void main(String[] args) {
    	Scanner input = null;
    	String inputLine;
    	TreeMap <String, Integer> wordCounter = new TreeMap<>();
    	
    	// Creates a file chooser dialog to allow the user to select a file.
    	JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt", "text");
		fc.setFileFilter(filter);
		
		// Displays the file chooser dialog and processes the chosen file.
		int status = fc.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {			
			try {
				
				input = new Scanner(fc.getSelectedFile());				
				// Read each line of the file.
				while (input.hasNextLine()){
					inputLine = input.nextLine();
					//Split each line into individual words.
					String [] words = inputLine.split("\\W+");
					
					// Use a TreeMap to store the words and their counts.
					for (int i=0; i<words.length; i++) {
						String word = words[i];
						wordCounter.put(word.toLowerCase(), wordCounter.getOrDefault(word.toLowerCase(),0)+1);
					}
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// Close the file scanner.
				if (input != null) {
					input.close();
				}
			}
			
			// Print all the words in the file to the console in alphabetical order,
			// along with the number of times each word appeared in the file.
			Iterator <Map.Entry<String, Integer>> i = wordCounter.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry<String, Integer> me = i.next();
				System.out.println(me.getKey() + " - " + me.getValue());
			}
			
		}
    }
}