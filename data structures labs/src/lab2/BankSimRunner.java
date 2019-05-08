package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class BankSimRunner {
	
	public static void main(String[] args) {
		//dos = duration of service
		LinkedList<Integer> arrival = new LinkedList<Integer>();
		LinkedList<Integer> dos = new LinkedList<Integer>();
		
		File file = new File("/lab2/customers.txt");
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
		
		Queue q = new Queue();
		q.enQueue(arrival.poll(), dos.poll());
		System.out.println(q.poll());
	}

}
