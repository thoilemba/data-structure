package queue;

/*
   A Circular Queue :
   When we try to increment the pointer and we reach the end of the queue,
   we start from the beginning of the queue.
   If size > capacity (overflow!), REAR = (REAR + 1)%capacity = 0 (start of queue)
*/

public class StaticQueue {
	
	int[] arr;
	int front;
	int rear;
	int size;
	int capacity;
	
	StaticQueue(int capacity){
		this.arr = new int[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
		this.capacity = capacity;
	}
	
	// Adding an element from the rear
	void enqueue(int element) {
		if(size == capacity) {
			System.out.println("Queue is full.");
		}else {
			if (front == -1) {
				front = 0;
			}
			rear = (rear+1)%capacity;
			arr[rear] = element;
			size++;
		}
	}
	
	// Removing an element from the front
	int dequeue() {
		if(size == 0) {
			System.out.println("Queue is empty.");
			return -1;
		}else {
			int temp = arr[front];
			if (front == rear) {
		        front = -1;
		        rear = -1;
		    }else { // Q has only one element, so we reset the queue after deleting it.
		       arr[front] = 0; // deleted element is replaced by 0
		       front = (front+1)%capacity;
		       size--;  
		    }
			
			return temp;
		}
	}
	
	// Getting the front element of the Queue
	int getFront() {
		if(size > 0) {
			return arr[front];
		}else {
			System.out.println("Queue is empty");
			return -1;
		}		
	}
	
	// Getting the rear element of the Queue
	int getRear() {
		if(size > 0) {
			return arr[rear];
		}else {
			System.out.println("Queue is empty");
			return -1;
		}		
	}
	
	boolean isFull() {
		return size == capacity;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	int size() {
		return size;
	}
	
	// Simply printing the Queue
	void printStaticQueue() {
		System.out.print("Queue : ");
		for(int i : arr) {
			System.out.print(i +" ");
		}
		System.out.println();
	}
	
	// Printing the Queue in order front-rear
	void display() {
		int i;
		System.out.print("Queue in order : ");
		if (isEmpty()) {
			System.out.println("Empty Queue");
		} else {
			for (i = front; i != rear; i = (i+1)%capacity) {
				System.out.print(arr[i] + " ");
		    }
			System.out.println(arr[i]);
		}
	}
	

	public static void main(String[] args) {
		StaticQueue staticQueue = new StaticQueue(5);
		
		System.out.println("Size : "+ staticQueue.size());
		System.out.println("Is empty : "+ staticQueue.isEmpty());
		System.out.println("Is full : "+ staticQueue.isFull());
		staticQueue.printStaticQueue();
		System.out.println();
		
		staticQueue.enqueue(10);
		staticQueue.enqueue(20);
		staticQueue.enqueue(30);
		staticQueue.enqueue(40);
		staticQueue.enqueue(50);
		staticQueue.printStaticQueue();
		System.out.println("Size : "+ staticQueue.size());
		System.out.println("Is empty : "+ staticQueue.isEmpty());
		System.out.println("Is full : "+ staticQueue.isFull());
		System.out.println("Front element : "+ staticQueue.getFront());
		System.out.println("Rear element : "+ staticQueue.getRear());
		System.out.println();
		

		staticQueue.enqueue(60); // adding beyond the capacity
		System.out.println("Removed : "+ staticQueue.dequeue());
		staticQueue.enqueue(60);
		System.out.println("Front : "+ staticQueue.front);
		System.out.println("Rear : "+ staticQueue.rear);
		staticQueue.printStaticQueue();
		staticQueue.display();
		System.out.println("Size : "+ staticQueue.size());
		System.out.println("Is empty : "+ staticQueue.isEmpty());
		System.out.println("Is full : "+ staticQueue.isFull());
		System.out.println("Front element : "+ staticQueue.getFront());
		System.out.println("Rear element : "+ staticQueue.getRear());
	}

}















