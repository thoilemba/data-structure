package doublylinkedlist;


class Node {
	Node previous;
	int data;
	Node next;
	
	Node(int data){
		this.previous = null;
		this.data = data;
		this.next = null;
	}
}

public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	// Printing the List
	void printLinkedList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// Printing the List in reverse order
	void printReverseLinkedList() {
		Node current = tail;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.previous;
		}
		System.out.println();
	}
	
	// Adding a node at the end of the list
	void append(int data) {
		Node newNode = new Node(data);
		
		// for empty list
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else { // non-empty
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
	}
	
	// Adding a node at the beginning of the list
	void addFirst(int data) {
		Node newNode = new Node(data);
		
		// for empty list
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else { // non-empty
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	
	// Adding a node at specific index
	void add(int index, int data) throws IndexOutOfBoundsException{
		if(index < 0) {
			System.out.println("Negative Index provided");
			throw new IndexOutOfBoundsException("Given negative index");
		}
		
		try {
			if(index == 0) {
				addFirst(data);
			}else {
				Node newNode = new Node(data);
				Node current = head;
				int count = 0;
				while(count < index-1) {
					current = current.next;
					count++;
				}
				current.next.previous = newNode;
				newNode.next = current.next;
				current.next = newNode;
				newNode.previous = current;
			}
		}catch(Exception e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	// Adding an array of nodes to the end of the List
	void addAll(int[] elements) {
		for(int element : elements) {
			append(element);
		}
	}
	
	// Removing first node from the List
	void removeFirst() {
		if(head == null) {
			System.out.println("Already an empty list.");
			return;
		}
		
		// having single element
		if(head.next == null) {
			head = null;
			tail = null;
		}else { // having multiple elements
			head = head.next;
			head.previous = null;
		}
	}
	
	// Removing first node from the List
	void removeLast() {
		if(head == null) {
			System.out.println("Already an empty list.");
			return;
		}
			
		// having single element
		if(head.next == null) {
			head = null;
			tail = null;
		}else { // having multiple elements
			tail = tail.previous;
			tail.next = null;
		}
	}
		
	// Removing a node from a specific index
	void remove(int index) {
		if(head == null || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		// having single element
		if(head.next == null && index == 0) {
			head = null;
			tail = null;
			return;
		}
		
    	// removing the first index
    	if(index == 0) {
    		head = head.next;
    		head.previous = null;
    		return;
    	}

		try {
			Node current = head;
			int count = 0;
			// traversing to the previous element of the specified index
			while(count < index-1) {
				current = current.next;
				count++;
			}
			if(current.next.next == null) {
				current.next = null;
				tail = null;
			}else {
				current.next = current.next.next;
				tail.previous = current;
				tail = current.next;
			}
		}catch(Exception e) {
			throw new IndexOutOfBoundsException();
		}
	}

	// Finding the index of an element (same as singly linked list)
	int indexOf(int element) {
		Node current = head;
		int index = 0;
		while(current != null) {
			if(current.data == element) {
				return index;
			}else {
				current = current.next;
				index++;
			}
		}
		
		return -1;
	}
	
	// Finding the last index of an element (same as singly linked list)
	int lastIndexOf(int element) {
		Node current = head;
		int index = 0;
		int result = -1;
		while(current != null) {
			if(current.data == element) {
				result = index;
			}
			current = current.next;
			index++;
		}
		
		return result;
	}
	
	// Finding the size of the List (same as singly linked list)
	int size() {
		int size = 0;
		Node current = head;
		while(current != null) {
			current = current.next;
			size++;
		}
		return size;
	}
	
	// Deleting a specified node from the List
	void deleteNode(Node nodeToDelete) {
		if(nodeToDelete == null) {
			return;
		}
		
		// Adjust the next node's previous reference
		if(nodeToDelete.next != null) {
			nodeToDelete.next.previous = nodeToDelete.previous;
		}else {
			// If the node to delete is the tail, update the tail
			tail = nodeToDelete.previous;
		}
		
		// Adjust the previous node's next reference
		if(nodeToDelete.previous != null) {
			nodeToDelete.previous.next = nodeToDelete.next;
		}else {
			// If the node to delete is the head, update the head
			head = nodeToDelete.next;
		}
		
		 // Clean up the node's references
		nodeToDelete.previous = null;
		nodeToDelete.next = null;
	}

	public static void main(String[] args) {
		
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		
		
		doublyLinkedList.append(10);
		doublyLinkedList.append(20);
		doublyLinkedList.append(30);
		doublyLinkedList.append(40);
		doublyLinkedList.append(50);
		System.out.print("Adding element using append() : ");
		doublyLinkedList.printLinkedList();
		System.out.println("head : "+ doublyLinkedList.head.data);
		System.out.println("tail : "+ doublyLinkedList.tail.data);
		
		System.out.print("Printing the list in reverse order : ");
		doublyLinkedList.printReverseLinkedList();
		
		doublyLinkedList.addFirst(40);
		System.out.print("Adding element using addFirst() : ");
		doublyLinkedList.printLinkedList();
		
		doublyLinkedList.add(3, 25);
		System.out.print("Adding element using add(index) : ");
		doublyLinkedList.printLinkedList();
		
		int[] arr = {40, 50};
		doublyLinkedList.addAll(arr);
		System.out.print("Adding element using addAll() : ");
		doublyLinkedList.printLinkedList();
		
		System.out.print("Removing element using removeFirst() : ");
		doublyLinkedList.removeFirst();
		doublyLinkedList.printLinkedList();
		
		System.out.print("Removing element using removeLast() : ");
		doublyLinkedList.removeLast();
		doublyLinkedList.printLinkedList();
		
		System.out.print("Removing element using remove(index) : ");
		doublyLinkedList.remove(2);
		doublyLinkedList.printLinkedList();
		
		int result = doublyLinkedList.indexOf(40);
		System.out.println("Index of 40 : "+ result);
		int result2 = doublyLinkedList.lastIndexOf(40);
		System.out.println("Last index of 40 : "+ result2);
		int result3 = doublyLinkedList.indexOf(70);
		System.out.println("Index of 70 : "+ result3);
		int result4 = doublyLinkedList.lastIndexOf(70);
		System.out.println("Last index of 70 : "+ result4);
		
		System.out.println("Size of the LinkedList : "+ doublyLinkedList.size());
		
		System.out.print("Deleting a node using delete(node) : ");
		doublyLinkedList.deleteNode(doublyLinkedList.head.next.next.next);
		doublyLinkedList.printLinkedList();

	}

}
