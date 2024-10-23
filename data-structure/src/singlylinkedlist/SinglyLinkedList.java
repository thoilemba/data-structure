package singlylinkedlist;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    // Method to print the list
    public void printList(){
        Node current = head;
        System.out.print("List: ");
        while(current != null){
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println("");
    }
    
    // Method to add a node to the beginning of the list
    public void addFirst(int data){
        System.out.println("add first "+ data);
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Method to add a node to the end of the list
    public void append(int data){
        System.out.println("Append " + data);
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        // traversing to the last element
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
    }

    // Method to find the length of the LinkedList
    public int length(){
        Node current = head;
        int count = 0;

        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    // Method to add a node to a specific index of the list
    public void add(int index, int data) throws IndexOutOfBoundsException {
        try{
            System.out.println("add at index "+index+": " + data);
            int length = length();

            if(index > length || index < 0){
                throw new IndexOutOfBoundsException("Index out of bound at index: "+index);
            }

            Node newNode = new Node(data);
            if(index == 0){
                addFirst(data);
            }else if(index == length){
                append(data);
            }else{
                Node current = head;
                int count = 0;
                while(count != index-1){
                    current = current.next;
                    count++;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // Method to add a node to a specific index of the list
    public void add2(int index, int data) throws IndexOutOfBoundsException {
    	System.out.println("add at index "+index+": " + data);
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index provided: " + index);
        }

        // Handle the case where index is 0 (inserting at the beginning)
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 0;

        // Traverse until the element before the desired index
        while (count < index - 1) {
            if (current == null) {  // Out of bounds
                throw new IndexOutOfBoundsException("Index out of bounds at index: " + index);
            }
            current = current.next;
            count++;
        }

        // If current is null here, index was out of bounds
        if (current == null || current.next == null && index != count + 1) {
            throw new IndexOutOfBoundsException("Index out of bounds at index: " + index);
        }

        // Insert the new node at the desired position
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to add an array of nodes
    public void addAll(int[] arr) {
    	System.out.println("Add all: ");
    	for(int i = 0; i < arr.length; i++) {
    		// Adding at the beginning
//    		OR // addFirst(arr[i]);
//    		Node newNode = new Node(arr[i]);
//            if (head == null) {
//                head = newNode;
//            }else {
//            	newNode.next = head;
//            	head = newNode;
//            }
    		
    		// Adding at the end
    		// // OR append(arr[i]);
    		
    		Node newNode = new Node(arr[i]);
            if (head == null) {
                head = newNode;
            }else {
            	Node current = head;
            	while(current.next != null) {
            		current = current.next;
            	}
            	current.next = newNode;
            }
    	}
    }

    // Method to remove a node from the beginning of the list
    public void removeFirst() {
    	System.out.print("Remove first: ");
    	if(head == null) {
    		System.out.println("Already an empty list");
    	}else {
    		head = head.next;
    	}
    }
    
    // Method to remove a node from the end of the list
    public void removeLast() {
    	System.out.print("Remove last: ");
    	if(head == null) {
    		System.out.println("Already an empty list");
    	}else if(head.next == null) {
    		head = null;
    	}else  {
    		Node current = head;
    		// traversing to the last second element
    		while(current.next.next != null) {
    			current = current.next;
    		}
    		current.next = null;
    	}
    }
    
    // Method to remove a node from a specific index
    public void remove(int index) throws IndexOutOfBoundsException {
    	System.out.print("Remove from index: "+index+" ");
    	if(head == null || index < 0) {
    		throw new IndexOutOfBoundsException("Index out of bound for index:"+ index);
    	}
    	
    	if(index == 0) {
    		head = head.next;
    		return;
    	}
    	
    	int count = 0;
    	Node current = head;
    	while(count != index-1) {
    		if(current == null) {
    			throw new IndexOutOfBoundsException("Index out of bound for index:"+ index);
    		}
    		count++;
    		current = current.next;
    	}
    	if(current == null || current.next == null) {
			throw new IndexOutOfBoundsException("Index out of bound for index:"+ index);
		}
    	current.next = current.next.next;
    }
    
    // Method to find the index of an element
    public int indexOf(int element) {
    	System.out.print("Index of "+element+": ");
    	int index = -1;
    	
    	Node current = head;
    	while(current != null) {
    		index++;
    		if(current.data == element) {
    			return index;
    		}
    		current = current.next;
    	}
    	return -1;
    }
    
    // Method to find the index of an element (last index if duplicate occurs)
    public int lastIndexOf(int element) {
    	System.out.print("Last index of "+element+": ");
    	int count = 0;
		int index = -1;
		
		Node current = head;
		while(current != null) {
			if(current.data == element) {
				index = count;
			}
			count++;
			current = current.next;
		}
		
		return index;
    }
    
    // Deleting a specified node from the List
    public void deleteNode(Node node) {
    	if(node == null || head == null) {
    		return;
    	}
    	
    	// first element
    	if(head == node) {
    		head  = node.next;
    		return;
    	}
    	
    	Node current = head;
    	
    	while(current.next != null) {
    		if(current.next == node) {
    			current.next = node.next;
    			node.next = null;
    			return;
    		}
    		current = current.next;
    	}
    }
    
 // Adding an element in a sorted order (ascending)
    public void addSorted(int data) {
    	
    	Node newNode = new Node(data);
    	
    	// having empty list
    	if(head == null) {
    		head = newNode;
    		return;
    	}
    	// having single element
    	if(head.next == null) {
    		if(data < head.data) {
    			newNode.next = head;
    			head = newNode;
    			return;
    		}else {
    			head.next = newNode;
    			return;
    		}
    	}
    	
    	if(data < head.data) {
    		newNode.next = head;
    		head = newNode;
    		return;
    	}
    	
    	// 1 3 5 7
    	Node current = head;
    	while(current.next != null && data >= current.next.data) {
    		current = current.next;
    	}
    	newNode.next = current.next;
    	current.next = newNode;
    	
    }
    
    public static void main(String[] args) {
        System.out.println("Singly Linkedlist implementation:");
        SinglyLinkedList list = new SinglyLinkedList();
//        Node node1 = new Node(30);
//        Node node2 = new Node(10);
//        Node node3 = new Node(20);
//        list.head = node1;
//        list.head.next = node2;
//        list.head.next.next = node3;
//        System.out.printf("List: %d %d %d %d\n",
//            list.head.data,
//            list.head.next.data,
//            list.head.next.next.data,
//            list.head.next.next.next
//        );
//        // System.out.printf("List: %d", list.head.next);
//        list.printList();
//        list.addFirst(50);
//        list.printList();
//        list.append(40);
//        list.printList();
//        System.out.println("Length: "+list.length());
//        list.add(-1, 70);
//        list.add(6, 80);
//        list.add(2, 70);
//        list.printList();
//        list.add2(24, 80);
        int[] arr = {1, 3, 5};
        list.addAll(arr);
//        list.printList();
//        list.removeFirst();
//        list.printList();
//        list.removeLast();
//        list.printList();
//        list.remove(6);
//        list.printList();
//        list.append(20);
//        list.printList();
//        System.out.println(list.indexOf(20));
//        System.out.println(list.lastIndexOf(20));
//        list.deleteNode(list.head.next.next);
        list.printList();
        list.addSorted(4);
        list.printList();
        
    }
}












