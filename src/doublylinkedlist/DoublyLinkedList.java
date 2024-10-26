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
	void printList() {
		System.out.print("List: ");
		Node current = head;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// Printing the List in reverse order
	void printListReverse() {
		System.out.print("List: ");
		Node current = tail;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.previous;
		}
		System.out.println();
	}
	
	// Adding a node at the end of the list
	void append(int data) {
		System.out.println("Append "+data+": ");
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
		System.out.println("Add first "+data+": ");
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
	
	// Adding a data at a specific index
	void add(int index, int data) {
		System.out.printf("Add %d at %d: ", data, index);
		if(index < 0 ||index > size()) {
			throw new IndexOutOfBoundsException("Index out of bound for index "+index);
		}
		
		Node newNode = new Node(data);
		
		if(index == 0) {
			addFirst(data);
		}else if(index == size()) {
			append(data);
		}else {
			Node current = head;
			int count = 0;
			while(count < index-1) {
				current = current.next;
				count++;
			}
			current.next.previous = newNode;
			newNode.next = current.next;
			newNode.previous = current;
			current.next = newNode;
		}
	}

	// Adding a data at a specific index without using other methods
	void add2(int index, int data) throws IndexOutOfBoundsException{
		System.out.printf("Add %d at index %d: \n", data, index);
		if(index < 0) {
			throw new IndexOutOfBoundsException("Negative index provided.");
		}
		
		Node newNode = new Node(data);
		if(index == 0) {
			if(head == null) {
				head = newNode;
				return;
			}
			
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
			return;
		}
		
		int count = 0;
		Node current = head;
		while(count != index-1) {
			if(current == null) {
				throw new IndexOutOfBoundsException("Index out of bound for index "+index);
			}
			current = current.next;
			count++;
		}
		
		if(current == null) {
			throw new IndexOutOfBoundsException("Index out of bound for index "+index);
		}
		
		newNode.next = current.next;
		if(current.next != null) {
			current.next.previous = newNode;
		}
		
		current.next = newNode;
	}

	// Adding an array of nodes to the end of the List
	void addAll(int[] elements) {
		for(int element : elements) {
			append(element);
		}
	}
	
	// Removing first node from the List
	void removeFirst() {
		System.out.print("Remove first: ");
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
		System.out.print("Remove last: ");
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
	void remove(int index) throws IndexOutOfBoundsException{
		System.out.println("Remove from index "+index+": ");
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		 // single element
		if(index == 0 && head == tail) {
			head = null;
			tail = null;
		}else if(index == 0) {
			head = head.next;
			head.previous = null;
		}else {
			Node current = head;
			int count = 0;
			while(count < index-1) {
				if(current == null) {
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
				count++;
			}
			if(current == null) {
				throw new IndexOutOfBoundsException();
			}
			
			if(current.next.next == null) {
				current.next = null;
				tail = current;
			}else {
				current.next = current.next.next;
			}
		}
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


	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		Node node1 = new Node(30);
		Node node2 = new Node(70);
		list.head = node1;
		list.tail = node1;
		list.head.next = node2;
		list.tail = node2;
		list.tail.previous = list.head;
		System.out.println("head: "+ list.head.data);
		System.out.println("head.next: "+ list.head.next.data);
		System.out.println("tail: "+ list.tail.data);
		System.out.println("tail.previous: "+ list.tail.previous.data);
		list.printList();
		list.printListReverse();
		
		// INSERTION
		System.out.println("INSERTION:");
		list.append(40);
		list.append(10);
		list.printList();
		list.addFirst(60);
		list.addFirst(20);
		list.printList();
		list.add(6, 50);
		list.printList();
		list.add2(7, 80);
		list.printList();
		int[] arr = {2, 3, 6};
		list.addAll(arr);
		list.printList();
		//	DELETION
		System.out.println("DELETION:");
		list.removeFirst();
		list.printList();
		list.removeLast();
		list.printList();
		list.remove(7);
		list.printList();
		list.printListReverse();
		list.deleteNode(list.tail.previous);
		list.printList();
		// INDEX OF
		System.out.println("INDEX OF:");
		System.out.println("Index of 2: "+ list.indexOf(2));
		list.addFirst(2);
		list.printList();
		System.out.println("Last index of 2: "+ list.lastIndexOf(2));
		System.out.println("Size: "+list.size());

	}
}
