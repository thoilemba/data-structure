package queue;

import stack.Stack;


class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class Queue {
	
	Node front;
	Node rear;
	int size;
	
	public Queue(){
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
		
	// Printing the Queue
	public void printQueue() {
		Node current = front;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// Checking if the Queue is empty or not
	public boolean isEmpty() {
		return size == 0;
		// OR front == null
	}
	
	// Adding element at the rear of the Queue
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if(size == 0) {
			front = newNode;
			rear = newNode;
			size++;
		}else {
			rear.next = newNode;
			rear = newNode;
			size++;
		}
	}
	
	// Removing element from the front of the Queue
	public int dequeue() {
		int removed = -1;
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return removed;
		}else {
			removed = front.data;
			front = front.next;
			size--;
			return removed;
		}
	}
	

	// Getting the front element of the Queue
	public int getFront() {
		if(size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}else {
			return front.data;
		}
	}
	
	// Getting the rear element of the Queue
	public int getRear() {
		if(size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}else {
			return rear.data;
		}
	}
	
	// Creating a new Queue by copying from the original Queue
	public Queue copyQueue(Queue oldQueue) {
		
		Node current = oldQueue.front;
		Queue newQueue = new Queue();
		while(current != null) {
			newQueue.enqueue(current.data);
			current = current.next;
		}
		
		return newQueue;
	}
	
	// Getting the Queue in reverse order using Stack
	// affects the original Queue
	public void reverseQueue(Queue passedQueue) {
		
		Stack tempStack = new Stack();
		
		while(!passedQueue.isEmpty()) {
			tempStack.push(passedQueue.dequeue());
		}
		
		while(!tempStack.isEmpty()) {
			try {
				passedQueue.enqueue(tempStack.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Getting the Queue in reverse order using Array
	// does not affect the original Queue
	public Queue reverseQueue2(Queue oldQueue) {
		
		Queue newQueue = new Queue();
		int[] arr = new int[oldQueue.size];
		
		Node current = oldQueue.front;

		int i = 0;
		// copying the elements of oldQueue to the array
		while(current != null) {
			arr[i] = current.data;
			current = current.next;
			i++;
		}
		
		for(i = arr.length-1; i >= 0; i--) {
			newQueue.enqueue(arr[i]);
		}

		return newQueue;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return front.data;
	}

	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
//		System.out.println("Removed : "+ queue.dequeue());
//		System.out.println("Peek : "+ queue.peek());
		
		System.out.println("Is empty : "+ queue.isEmpty());
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.print("Queue : ");
		queue.printQueue();
		System.out.println("Is empty : "+ queue.isEmpty());
		System.out.println();
		
		System.out.print("Copy Queue : ");
		Queue copyQueue = queue.copyQueue(queue);
		copyQueue.printQueue();
		
		System.out.print("Reverse Queue (using Array) : ");
		Queue newQueue = queue.reverseQueue2(queue);
		newQueue.printQueue();
		
		System.out.println("Peek : "+ queue.peek());
		System.out.print("Reverse Queue (using Stack) : ");
		queue.reverseQueue(queue);
		queue.printQueue();

		System.out.println();
		System.out.println("Front element : "+ queue.getFront());
		System.out.println("Rear element : "+ queue.getRear());
		System.out.println("Is empty : "+ queue.isEmpty());
		System.out.println("Removed : "+ queue.dequeue());
		System.out.print("Queue : ");
		queue.printQueue();
		
		
	}

}









