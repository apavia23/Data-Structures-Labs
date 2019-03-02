package labUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {
	private Node head;

	public void insertFirst(E data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}
	
	public void add(E data) {
		Node newNode = new Node();
		newNode.data = data;
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
	
	public void insert(E data, int index) {
		Node newNode = new Node();
		newNode.data = data;
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
		Node n = head;
		for(int i = 0; i < index; i++) {
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	
	class Node {
		public E data;
		public Node next;
	}

	class IteratorHelper implements Iterator<E>{

		Node current;
		public IteratorHelper() {
			current = head;
		}
		public boolean hasNext() {
			return (current != null);
		}

		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E val = current.data;
			current = current.next;
			return val;
		}	
	}
}
