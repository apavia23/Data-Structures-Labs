package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankSimRunner {
	
	public static void main(String[] args) {
		//dos = duration of service
		Queue<Integer> arrival = new LinkedList<Integer>();
		Queue<Integer> dos = new LinkedList<Integer>();
		
		File file = new File("custoners.txt");
		try {
			Scanner fileIn = new Scanner(file);
			while(fileIn.hasNextInt()) {
				arrival.add(fileIn.nextInt());
				dos.add(fileIn.nextInt());
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist");
			e.printStackTrace();
		}
		
		int runtime = 0;
		
		
	}

}
