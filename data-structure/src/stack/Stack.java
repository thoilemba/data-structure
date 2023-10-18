package stack;


class StackOverflowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	StackOverflowException(){
		super("Stack is full.");	
	}
}

class StackUnderflowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	// getMessage is a built-in method of Exception class
	@Override
	public String getMessage() {
		// return super.getMessage();
		return "Stack is empty";
	}
}


class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

// Implementing Stack using Singly Linked List
public class Stack {
	
	Node top; // same as the head node in Linked List
	int size;
	
	Stack(){
		this.top = null;
		this.size = 0;
	}
	
	void printStack() {
		Node current = top;
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.next;
		}
		System.out.println();
	}
	
	// Adding element (same as addFirst in LinkedList)
	void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	// Removing element (same as removeFirst in LinkedList)
	int pop() throws StackUnderflowException{
		if(top == null) {
			throw new StackUnderflowException();
		}
		int poppedData = top.data;
		top = top.next;
		size--;
		return poppedData;
	}
	
	// Getting the top element
	int peek() {
		if(top == null) {
			return -1;
		}else {
			return top.data;
		}
	}
	
	// Checking if the Stack is empty
	boolean isEmpty() {
		return size == 0;
		// OR
		// return top == null;
	}
	
	// Getting the size of the Stack
	int size() {
		int size = 0;
		Node current = top;
		while(current != null) {
			current = current.next;
			size++;
		}
		return size;
	}
	


	public static void main(String[] args) throws StackUnderflowException {
		
		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.printStack();
		System.out.println("Size of the Stack : "+ stack.size());
		System.out.println("Size of the Stack : "+ stack.size);
		System.out.println("Peek : "+ stack.peek());
		System.out.println("Is Empty : "+ stack.isEmpty());
		
		System.out.println("Popped : "+ stack.pop());
		System.out.println("Popped : "+ stack.pop());
		System.out.println("Popped : "+ stack.pop());

		System.out.println("Size of the Stack : "+ stack.size());
		System.out.println("Size of the Stack : "+ stack.size);
		

		

	}

}













