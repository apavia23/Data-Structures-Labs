package labUtils;

import java.util.NoSuchElementException;

public class LinkList<T> {
	Node<T> first;
	Node<T> last;
	
	public LinkList(){
		Node<T> first = new Node<T>(null);
		first.next = null;
		Node<T> last = new Node<T>(null);
		last.next = null;
	}
	
	public void insertFirst(T input) {
		Node<T> newNode = new Node<T>(input);
		if(first.next == null) {
			first.next = newNode;
		}else {
			newNode.next = first.next;
			first.next = newNode;
		}
	}
	
	public void insertLast(T input) {
		Node<T> newNode = new Node<T>(input);
		if(first.next == null) {
			first.next = newNode;
		}else {
			last.next.next = newNode;
			last.next = newNode;
		}
	}
	
	public void removeFirst() {
		if(first.next == null) {
			throw new NoSuchElementException();
		}
		first.next = first.next.next;
	}
	
	public void print() {
		Node<T> temp = first.next;
		if(first.next == null) {
			System.out.println("List is empty");
		}else {
			do {
				System.out.println(temp.data);
				temp = temp.next;
			}while(temp.next != null);
		}
	}
}
