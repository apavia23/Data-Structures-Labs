package lab2;

import java.util.NoSuchElementException;

public class LinkedList {
	private Node head;
	
	public void add(Customer newCust) {
		Node newNode = new Node(newCust);
		newNode.next = null;
		
		if(head == null) {
			head = newNode;
		}else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = newNode;
		}
	}
	
	public void removeFirst() {
		if(head == null) {
			throw new NoSuchElementException();
		}else {
			Node n = head.next;
			head.next = null;
			head = n;
		}
	}
	
	public void doTellerProcess(int tellers) {
		Node n = head;
		for(int i = 0; i < tellers; i++) {
			n.customer.dos--;
			if(n.next != null) {
				n = n.next;
			}else {
				break;
			}
		}
	}
	
	public int returnFinishedCustomersArrivalTimes(int tellers) {
		Node n = head;
		int retVal = 0;
		for(int i = 0; i < tellers; i++) {
			if(n.customer.dos == 0) {
				retVal = retVal + n.customer.arrivalTime;				
			}
			if(n.next != null) {
				n = n.next;
			}else {
				break;
			}
		}
		return retVal;
	}
	
	public void removeFirstIfFinished() {
		if(head.customer.dos == 0) {
			Node n = head.next;
			head.next = null;
			head = n;
		}
	}
	
	public void removeRestIfFinished(int tellers) {
		for(int i = 0; i < tellers; i++) {
			Node n = head;
			
		}
	}
	
	public boolean isEmpty() {
		if(head = null)
	}
	
	public void print(int index) {
		if(head == null) {
			System.out.println("List is empty");
		}else {
			Node n = head;
			for(int i = 0; i < index; i++) {
				n = n.next;
			}
			System.out.println(n.customer.total);
		}
	}
	
	public void printAll() {
		if(head == null) {
			System.out.println("List is empty");
		}else {
			Node n = head;
			do {
				System.out.println(n.customer.total);
				n = n.next;
			}while(n.next != null);
			System.out.println(n.customer.total);
		}
	}
	
	class Node {
		public Customer customer;
		public Node next;
		
		Node(Customer input){
			customer = input;
		}
	}
}
