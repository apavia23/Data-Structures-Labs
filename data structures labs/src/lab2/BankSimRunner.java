package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankSimRunner {
	
	public static void main(String[] args) {
		Customer[] customers = new Customer[50];

		File file = new File("C:\\Users\\austi\\git\\Data-Structures-Labs\\data structures labs\\src\\lab2\\customers.txt");
		try {
			Scanner fileIn = new Scanner(file);
			int i = 0;
			while(fileIn.hasNextInt()) {
				customers[i] = new Customer(0, 0);
				customers[i].arrivalTime = fileIn.nextInt();
				customers[i].dos = fileIn.nextInt();
				i++;
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist");
			e.printStackTrace();
		}
		
		Scanner kb = new Scanner(System.in);

		System.out.print("Enter the number of tellers to simulate: ");
		int tellers = kb.nextInt();
		kb.close();
		int runtime = 0;
		Customer[] line = new Customer[50];
		int combinedTotal = 0;
		
		while(true) {
			//add customer to line if arrival time is met
			for(Customer i : customers) {
				if(i.arrivalTime == runtime) {
					for(int j = 0; j < 50; j++) {
						if(line[j] == null) {
							line[j] = i;
							break;
						}
					}
				}else if(i.arrivalTime > runtime) {
					break;
				}
			}	
			//process services
			//line.doTellerProcess(tellers);
			for(int i = 0; i < tellers; i++) {
				if(line[i] != null) {
					line[i].dos--;
				}else {
					break;
				}
			}
			
			//remove finished customers and add their total time to combined total
			//combinedTotal = combinedTotal + line.returnFinishedCustomersArrivalTimes(tellers);
			for(int i = 0; i < tellers; i++) {
				if(line[i] != null && line[i].dos == 0) {
					combinedTotal = combinedTotal + (runtime - line[i].arrivalTime);
					line[i] = null;
				}
			}
			
			//Shuffle down customers in line if someone left
			//wanted to do this all with a linked list instead of an array but it would require more brain cells than I have available right now
			for(int i = 0; i < tellers; i++) {
				for (int j = 0; j < line.length; j++){
					if (line[j]==null){
						for (int k = j + 1; k < line.length; k++){
							line[k-1] = line[k];
						}
						line[line.length-1] = null;
						break;
					}
				}
			}
			
			//if both arrays are empty, no customers remain, so exit main loop
			if(line[0] == null) {
				break;
			}
			
			runtime++;	
		}
		
		double averageProcess = combinedTotal / 50.0;
		System.out.println("total simulation time: " + runtime);
		System.out.println("average process time for customers: " + averageProcess);
	}
}
