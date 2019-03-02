package lab2;

public class Customer {
	//dos = Duration of service
	int id, arrivalTime, dos;
	
	Customer(int id, int arrivalTime, int dos){
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.dos = dos;
	}
	
	void print() {
		System.out.println("id: " + this.id);
		System.out.println("Arrival Time: " + this.arrivalTime);
		System.out.println("Duration of Service: " + this.dos);
	}
}
