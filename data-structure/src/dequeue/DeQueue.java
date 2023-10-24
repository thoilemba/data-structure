package dequeue;


/*
 Implementing the DeQueue using Doubly Linked List.
 So, it is same as the Doubly Linked List implementation.
 Insertion and deletion methods implementation are also similar.
 Only small changes because of the size property. 
 */

class Node {
	int data;
	Node next;
	Node previous;
	
	Node(int data){
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

// DeQueue = Double Ended Queue - Insertion and deletion performs at both ends
public class DeQueue {
	
	Node front;
	Node rear;
	int size;
	
	public DeQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	
	// Checking if the DeQueue is empty or not
	boolean isEmpty(){
		return size == 0;
	}
	
	// Printing the DeQueue
	void printDeQueue() {
		Node current = front;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// Printing the DeQueue in reverse order
	void printReverseDeQueue() {
		Node current = rear;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.previous;
		}
		System.out.println();
	}
	
	
	// Adding element at the front of the DeQueue
	void offerFirst(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			size++;
		}else {
			front.previous = newNode;
			newNode.next = front;
			front = newNode;
			size++;
		}
	}
	
	// Adding element at the rear of the DeQueue
	void offerLast(int data) {
		Node newNode = new Node(data);
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			size++;
		}else {
			rear.next = newNode;
			newNode.previous = rear;
			rear = newNode;
			size++;
		}	
	}
	
	// Removing element from the front of the DeQueue
	int pollFirst() {
		if(isEmpty()) {
			System.out.println("DeQueue is empty.");
			return -1;
		}else if(front.next == null){ // single element
			int removedData = front.data;
			front = null;
			rear = null;
			size--;
			return removedData;
		}else {
			int removedData = front.data;
			front = front.next;
			front.previous = null;
			size--;
			return removedData;
		}
	}
	
	// Removing element from the rear of the DeQueue
	int pollLast() {
		if(isEmpty()) {
			System.out.println("DeQueue is empty.");
			return -1;
		}else if(front.next == null){ // single element
			int removedData = front.data;
			front = null;
			rear = null;
			size--;
			return removedData;
		}else {
			int removedData = rear.data;
			rear = rear.previous;
			rear.next = null;
			size--;
			return removedData;
		}
	}
	
	// Retrieving the front element from the DeQueue
	int peekFirst() {
		if(isEmpty()) {
			System.out.println("DeQueue is empty.");
			return -1;
		}else {
			return front.data;
		}
	}
	
	// Retrieving the rear element from the DeQueue
	int peekLast() {
		if(isEmpty()) {
			System.out.println("DeQueue is empty.");
			return -1;
		}else {
			return rear.data;
		}	
	}
	

	public static void main(String[] args) {
		DeQueue deQueue = new DeQueue();
		
		System.out.println("Is empty : "+ deQueue.isEmpty());
		System.out.println("Size : "+ deQueue.size);

		
		deQueue.offerLast(10);
		deQueue.offerLast(20);
		deQueue.offerLast(30);
		deQueue.offerLast(40);
		deQueue.offerFirst(11);
		System.out.print("DeQueue : ");
		deQueue.printDeQueue();
		System.out.print("DeQueue reverse : ");
		deQueue.printReverseDeQueue();
		System.out.println("Size : "+ deQueue.size);
		
		
		System.out.println("PollFirst : "+ deQueue.pollFirst());
		System.out.println("PollLast : "+ deQueue.pollLast());
		
		System.out.println("Size : "+ deQueue.size);
		
		System.out.print("DeQueue : ");
		deQueue.printDeQueue();
		System.out.println("PeekFirst : "+ deQueue.peekFirst());
		System.out.println("PeekLast : "+ deQueue.peekLast());
		
		
		
		
	}

}













