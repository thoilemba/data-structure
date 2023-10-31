package binary_tree;

import java.util.Stack;

class Node {
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {
	
	Node root;
	
	BinaryTree() {
		root = null;
	}
	
	static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data +" ");
			inOrder(root.right);
		}
	}
	
	static void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data +" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	static void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data +" ");
		}
	}
	
	public static void inorderWithoutRecursion(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " "); // Process the node
            current = current.right;
        }
    }
	
	public static void preorderWithoutRecursion(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " "); // Process the node

            // Push the right child first (if it exists) so that the left child is processed first
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
	
	public static void postorderWithoutRecursion(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        
        // In this loop, stack1 process the nodes in the reverse order 
        // i.e. Root-Right-Left and pushing it into stack2
        while (!stack1.isEmpty()) {
        	Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // stack2 contains the node in Post order sequence
        while (!stack2.isEmpty()) {
        	Node current = stack2.pop();
            System.out.print(current.data + " "); // Process the node
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
		Node root = null;
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.right.left =  new Node(50);
		root.right.right = new Node(60);
		
		System.out.print("Inorder Traversal : ");
		inOrder(root);
		System.out.print("\nInorder (Without Recursion): ");
		inorderWithoutRecursion(root);
		
		System.out.print("\nPreorder Traversal : ");
		preOrder(root);
		System.out.print("\nPreorder (Without Recursion): ");
		preorderWithoutRecursion(root); 
		
		System.out.print("\nPostorder Traversal : ");
		postOrder(root);
		System.out.print("\nPostorder (Without Recursion): ");
		postorderWithoutRecursion(root); 


	}

}
