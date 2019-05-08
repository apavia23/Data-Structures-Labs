package lab2;

public class Customer {
	//dos = Duration of service
	int arrivalTime, dos;
	
	Customer(int arrivalTime, int dos){
		this.arrivalTime = arrivalTime;
		this.dos = dos;
	}
	
	void print() {
		System.out.println("Arrival Time: " + this.arrivalTime);
		System.out.println("Duration of Service: " + this.dos);
	}
}
