package lab2;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	private Node head;

	public void insertFirst(T data1, T data2) {
		Node newNode = new Node(data1, data2);
		newNode.next = head;
		head = newNode;
	}
	
	public void add(T data1, T data2) {
		Node newNode = new Node(data1, data2);	
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
	
	public void insert(T data1, T data2, int index) {
		Node newNode = new Node(data1, data2);
		if(head == null) {
			head = newNode;
		}else {
			Node n = head;
			for(int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			newNode.next = n.next;
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
	
	//Will not remove if it is the only element in list. use removeFirst()
	public void removeLast() {
		if(head == null) {
			throw new NoSuchElementException();
		}else {
			Node n = head;
			while(n.next.next != null) {
				n = n.next;
			}
			n.next = null;
		}
	}
	
	public void remove(int index) {
		if(head == null) {
			throw new NoSuchElementException();
		}else {
			Node n = head;
			for(int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			Node n2 = n.next;
			n.next = n2.next;
			n2.next = null;
		}
	}
	
	public void print(int index) {
		if(head == null) {
			System.out.println("List is empty");
		}else {
			Node n = head;
			for(int i = 0; i < index; i++) {
				n = n.next;
			}
			System.out.println(n.data1 + ", " + n.data2);
		}
	}
	
	public void printAll() {
		if(head == null) {
			System.out.println("List is empty");
		}else {
			Node n = head;
			do {
				System.out.println(n.data1 + ", " + n.data2);
				n = n.next;
			}while(n.next != null);
			System.out.println(n.data1 + ", " + n.data2);
		}
	}
	
	class Node {
		public T data1;
		public T data2;
		public Node next;
		
		Node(T input1, T input2){
			data1 = input1;
			data2 = input2;
		}
	}
}
