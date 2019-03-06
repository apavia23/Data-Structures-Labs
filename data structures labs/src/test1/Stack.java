package test1;

import java.util.EmptyStackException;

public class Stack<T> implements IDKWhyINeedThis<T>{
	private Node head;
	
	public void push(T data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public T pop() {
		if(head == null) {
			throw new EmptyStackException();
		}else {
			T data = head.data;
			Node n = head.next;
			head.next = null;
			head = n;
			return data;
		}
	}
	
	public T peek() {
		if(head == null) {
			throw new EmptyStackException();
		}else {
			return head.data;
		}
	}
	
	public boolean empty() {
		if(head == null) {
			return true;
		}else {
			return false;
		}
	}
	
	class Node {
		public T data;
		public Node next;
			
		Node(T input){
			data = input;
		}
	}
}