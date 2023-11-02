package binary_tree;

import java.util.LinkedList;
import java.util.Queue;


// Queue that stores Tree node
class QNode {
	TreeNode data;
	QNode next;
	
	QNode(TreeNode data){
		this.data = data;
		this.next = null;
	}
}


class TempQueue {
	QNode front;
	QNode rear;
	int size;
	
	TempQueue(){
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	// Checking if the Queue is empty or not
	boolean isEmpty() {
		return size == 0;
		// OR front == null
	}
	
	// Adding element at the rear of the Queue
	void enqueue(TreeNode data) {
		QNode newNode = new QNode(data);
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
	TreeNode dequeue() {
		TreeNode removed = null;
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
}


class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}



public class BinaryTreeWithCustomQueue {
	
	TreeNode root;
	
	BinaryTreeWithCustomQueue() {
		root = null;
	}
	
	// Using built-in Queue
	// space complexity: maximum width of the tree (level having max no. of nodes)
	public static void breadthFirst(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode current = q.poll();
			System.out.print(current.data +" ");
				
			if(current.left != null) {
				q.add(current.left);
			}
			if(current.right != null) {
				q.add(current.right);
			}
		}
	}
	
	// Using Custom Queue
	public static void breadthFirstCustomQueue(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		TempQueue q = new TempQueue();
		
		q.enqueue(root);
		while(!q.isEmpty()) {
			TreeNode current = q.dequeue();
			System.out.print(current.data +" ");
				
			if(current.left != null) {
				q.enqueue(current.left);
			}
			if(current.right != null) {
				q.enqueue(current.right);
			}
		}
	}
	
	
    /*
    	Example Tree:
         	 10
        	/  \
       	   20   30
      	  /  	/ \
     	40 	   50  60
    */

	public static void main(String[] args) {
		TreeNode root = null;
		root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.right.left =  new TreeNode(50);
		root.right.left.right =  new TreeNode(777);
		root.right.right = new TreeNode(60);
		
		System.out.println("Breadth First/Level Order: ");
		breadthFirst(root);
		
		System.out.println();
		breadthFirstCustomQueue(root);

	}

}
