package singlylinkedlist;


// Create a Node class to represent individual elements of the list
// This Node class can store only integer data type

class Node {
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}


// Create a LinkedList class to manage the list
public class SinglyLinkedList {

	private Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
    
    
    // Method to print the list
	public void printLinkedList() {
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data +" ");
			current = current.next;
		}
	}
	
	
    //TODO: Method to add a node to the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head; // previous head becomes second element
        head = newNode; // newNode becomes the head
    }
    
    
    // Method to add a node to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        // traversing to the last element
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    
    // Method to add a node to a specific index of the list
    public void add(int index, int data) throws IndexOutOfBoundsException {
    	try {
    		if(index < 0) {
    			System.out.println("Negative index provided.");;
    		}
    		
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
        		newNode.next = current.next;
        		current.next = newNode;
        	}
    	}catch(Exception e) {
    		throw new IndexOutOfBoundsException();
    	}
    }
    
    
    // Method to add an array of nodes to the end of the list
    public void addAll(int[] elements) {
		for(int element : elements) {
    		append(element);
    	}
    }
    
    
    // Method to remove a node from the beginning of the list
    public void removeFirst() {
    	if(head == null) {  // having no elements
    		System.out.println("Already an empty list");
    	}else if(head.next == null) {  // having single element
    		head = null;
    	}else {  // having multiple elements
    		Node current = head;
    		head = head.next;
    		current.next = null;
    	}
    }
    
    
    // Method to remove a node from the end of the list
    public void removeLast() {
    	if(head == null) {
    		System.out.println("Already an empty list");
    	}else if(head.next == null) {
    		head = null;
    	}else {
    		Node current = head;
            // traversing to the last second element
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
    	}
    }
    
    // Method to remove a node from a specific index
    public void remove(int index) throws IndexOutOfBoundsException {
    	// empty list
    	if(head == null || index < 0) {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	// having single element
    	if(head.next == null && index == 0) {
    		head = null;
    		return;
    	}
    	
    	// removing the first index
    	if(index == 0) {
    		head = head.next;
    		return;
    	}
    	
    	try {
    		Node current = head;
    		int count = 0;
    		while(count < index-1) {
    			current = current.next;
    			count++;
    		}
    		if(current.next.next != null) {
    			current.next = current.next.next;
    		}else {
    			current.next = null;
    		}
    	}catch(Exception e) {
    		throw new IndexOutOfBoundsException();
    	}
    }
    
    
    // Method to find the index of an element
    public int indexOf(int element) {
    	
    	Node current = head;
    	int index = 0;
    	
    	while(current != null) {
    		if(current.data == element) {
    			return index;
    		}
    		current = current.next;
    		index++;
    	}
    	
    	return -1;
    }
    
    
    // Method to find the index of an element (last index if duplicate occurs)
    public int lastIndexOf(int element) {
    	
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
    
    
    // Method to find the size of the LinkedList
    public int size() {
    	Node current = head;
    	int count = 0;
    	
    	while(current != null) {
    		count++;
    		current = current.next;
    	}
    	
    	return count;
    }
    
    // Deleting a specified node from the List
    void deleteNode(Node nodeToDelete) {
    	if(nodeToDelete == null || head == null) {
    		return;
    	}
    	
    	if(head == nodeToDelete) {
    		head  = nodeToDelete.next;
    		return;
    	}
    	
    	Node current = head;
    	
    	while(current.next != null) {
    		if(current.next == nodeToDelete) {
    			current.next = nodeToDelete.next;
    			nodeToDelete.next = null;
    			return;
    		}
    		current = current.next;
    	}
    }

    // Adding an element in a sorted order (ascending)
    void addSorted(int data) {
    	Node newNode = new Node(data);
    	
    	if(head == null) {
    		head = newNode;
    		return;
    	}
    	
    	// new element is smaller than the first element
    	if(newNode.data < head.data) {
    		newNode.next = head;
    		head = newNode;
    		return;
    	}
    	    	
    	Node current = head;
    	// Traversing till the last second element
    	while(current.next != null) {
    		if(newNode.data > current.data && newNode.data < current.next.data) {
    			newNode.next = current.next;
    			current.next = newNode;
    			return;
    		}
    		current = current.next;
    	}
    	// when the new element is the biggest (does not satisfied all the above cases
    	current.next = newNode;
    	
    	// OR
//    	Node current = head;
//    	// Finding the element which is bigger than the new element
//    	while(current.next != null && newNode.data > current.next.data) {
//    		current = current.next;
//    	}
//    	newNode.next = current.next;
//		current.next = newNode;
    }

	public static void main(String[] args) {
		SinglyLinkedList myLinkedList = new SinglyLinkedList();
		
// 		Without using the methods

//		Node n1 = new Node(10);
//		Node n2 = new Node(20);
//		Node n3 = new Node(30);
//		Node n4 = new Node(40);
//		myLinkedList.head = n1;		
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		myLinkedList.printLinkedList();
		
		myLinkedList.append(10);
		myLinkedList.append(20);
		myLinkedList.append(30);
		myLinkedList.append(40);
		myLinkedList.append(50);
		System.out.print("Adding element using append() : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		myLinkedList.addFirst(40);;
		System.out.print("Adding element using addFirst() : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		myLinkedList.add(4, 25);
//		myLinkedList.add(-10, 3);
//		myLinkedList.add(10, 200); // IndexOutOfBoundsException
		System.out.print("Adding element using add(index) : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		int[] arr = {40, 50};
		myLinkedList.addAll(arr);
		System.out.print("Adding elements using addAll() : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		
		myLinkedList.removeFirst();
		System.out.print("Removing element using removeFirst() : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		myLinkedList.removeLast();
		System.out.print("Removing element using removeLast() : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		myLinkedList.remove(3);
		System.out.print("Removing element using remove(index) : ");
		myLinkedList.printLinkedList();
		System.out.println();
		
		int result = myLinkedList.indexOf(40);
		System.out.println("Index of 40 : "+ result);
		int result2 = myLinkedList.lastIndexOf(40);
		System.out.println("Last index of 40 : "+ result2);
		int result3 = myLinkedList.indexOf(70);
		System.out.println("Index of 70 : "+ result3);
		int result4 = myLinkedList.lastIndexOf(70);
		System.out.println("Last index of 70 : "+ result4);
		
		System.out.println("Size of the LinkedList : "+ myLinkedList.size());
		
		System.out.print("Deleting a node using delete(node) : ");
		myLinkedList.deleteNode(myLinkedList.head.next.next.next);
//		myLinkedList.deleteNode(myLinkedList.head.next.next.next.next.next);
		myLinkedList.printLinkedList();
	
	}

}










