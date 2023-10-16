package circular_linked_list;


class Node {
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class CircularLinkedList {
	
	private Node head;
	
	public CircularLinkedList() {
		this.head = null;
	}
	
	// Printing the List
	void printList() {
		if(head != null) {
			Node current = head.next;
			System.out.print(head.data +" ");
			while(current != head) {
				System.out.print(current.data +" ");
				current = current.next;
			}
			System.out.println();
		}
	}
	
	// Printing the List using do-while loop
	void printList2() {
		if(head != null) {
			Node current = head;
			do {
				System.out.print(current.data +" ");
				current = current.next;
			}
			while(current != head);
			System.out.println();
		}
	}

	// Adding an element at the beginning of the List - O(n)
	void addFirst(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			head.next = head;
		}else {
			Node current = head;
			// we need to traverse till the last element to update the next reference
			while(current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	
	// Adding an element at the beginning of the List - O(1)
	void addFirstEfficient(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			head.next = head;
		}else {
			// Adding the newNode at second index and swapping the data
			// of head with the newNode data
			newNode.next = head.next;
			head.next = newNode;
			int temp = head.data;
			head.data = newNode.data;
			newNode.data = temp;
		}
	}

	// Adding an element at the end of the List - O(n)
	void addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			head.next = head;
		}else {
			Node current = head;
			while(current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
		}
	}
	
	// Adding an element at the end of the List - O(1)
	void addLastEfficient(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			head.next = head;
		}else {
			// Adding the newNode at second index and swapping the data
			// of head with the newNode data
			newNode.next = head.next;
			head.next = newNode;
			int temp = head.data;
			head.data = newNode.data;
			newNode.data = temp;
			// now head points to the previous head's element
			head = head.next; 
		}
	}
	
	// Removing first element of the List - O(n)
	void removeFirst() {
		if(head == null) {
			return;
		}
		
		// single element
		if(head == head.next) {
			head = null;
		}else { // multiple element
			Node current = head;
			// we need to traverse till the last element to update the next reference
			while(current.next != head) {
				current = current.next;
			}
			// last element and head points to the second element
			current.next = head.next;
			head = head.next;
		}
	}
	
	// Removing first element of the List - O(1)
	void removeFirstEfficient() {
		if(head == null) {
			return;
		}
		
		// single element
		if(head == head.next) {
			head = null;
		}else { // multiple element
			// swapping the data of first and the second
			int temp = head.data;
			head.data = head.next.data;
			head.next.data = temp;
			// head's next pointing to the third node (removing the second)
			head.next = head.next.next;
			// in case of having two element, head.next points to the same element
		}
	}
	
	// Removing last element of the List - O(n)
	// This method can't be solved in O(1).
	void removeLast() {
		if(head == null) {
			return;
		}
		
		// single element
		if(head == head.next) {
			head = null;
		}else { // multiple element
			Node current = head;
			// traversing to the last second element
			while(current.next.next != head) {
				current = current.next;
			}
			// last second element's next pointing to head
			current.next = head;
		}
	}
	
	
	public static void main(String[] args) {

		CircularLinkedList circularLinkedList = new CircularLinkedList();
		
		circularLinkedList.head = new Node(10);
		circularLinkedList.head.next = new Node(20);
		circularLinkedList.head.next.next = new Node(30);
		circularLinkedList.head.next.next.next = circularLinkedList.head;
		
		circularLinkedList.printList();
		circularLinkedList.printList2();
		
		System.out.print("Added element using addFirst() : ");
		circularLinkedList.addFirst(40);
		circularLinkedList.printList();
		
		System.out.print("Added element using addFirstEfficient() : ");
		circularLinkedList.addFirstEfficient(50);
		circularLinkedList.printList();
		
		System.out.print("Added element using addLast() : ");
		circularLinkedList.addLast(40);
		circularLinkedList.printList();
		
		System.out.print("Added element using addLastEfficient() : ");
		circularLinkedList.addLastEfficient(50);
		circularLinkedList.printList();
		
		System.out.print("Removed first element using removeFirst() : ");
		circularLinkedList.removeFirst();
		circularLinkedList.printList();

		System.out.print("Removed first element using removeFirstEfficient() : ");
		circularLinkedList.removeFirstEfficient();
		circularLinkedList.printList();
		
		System.out.print("Removed last element using removeLast() : ");
		circularLinkedList.removeLast();
		circularLinkedList.printList();
		
		// indexOf(), size(), add(index), remove(index), etc. are same as the previous implementation
		
	}

}
