package io;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecord  {
	
	public void addScore(int score) {

		FileWriter gameWriter;
		try {
			gameWriter = new FileWriter("scoreRecord", true);
			gameWriter.write(String.valueOf(score));
			gameWriter.write("\n");
			gameWriter.close();
		} 
		catch (IOException exp) {
			System.out.print("Cannot Record Result");
		}
	}

//	public static void main(String[] args) {
//		new FileRecord().addScore(1000);
//	}

}