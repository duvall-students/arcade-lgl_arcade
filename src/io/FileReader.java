package io;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileReader  {
	
	
	private ArrayList<Integer> topTenScores;

	
	private ArrayList<Integer> allScores;

	
	private Scanner fileScanner = null;
	
	
	// This method returns an ArrayList containing all recorded game scores (in order from highest score to lowest)
	
	public ArrayList<Integer> getAllScores() {

		// Initialize the return ArrayList
		allScores = new ArrayList<Integer>();

		// Attempt to add a score to the return ArrayList
		try {
			fileScanner  = new Scanner(new File("ScoreRecord"));
			while(fileScanner.hasNextLine()) {
				int oneScore = Integer.parseInt(fileScanner.nextLine());
				allScores.add(oneScore);
			}
		}
		catch (IOException  exp) {
			System.out.print("Error: File Read Incorrectly");
		}
		finally {
			if(fileScanner != null)
				fileScanner.close();
		}

		// Sort all of the scores from highest score to lowest
		Collections.sort(allScores, Collections.reverseOrder());
		
		return allScores;
	}
	

	// This method returns an ArrayList containing the top ten highest game scores
	public ArrayList<Integer> getHighScores() {
		topTenScores = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++) {
			topTenScores.add(this.getAllScores().get(i));
		}
		return topTenScores;
	}

	public static void main(String[] args) {
		new FileReader().getAllScores();
	
	}
}