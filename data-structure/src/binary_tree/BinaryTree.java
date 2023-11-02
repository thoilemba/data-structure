package binary_tree;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


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

	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}else {
			int leftHeight = heightOfTree(root.left);
			int rightHeight = heightOfTree(root.right);
			return (leftHeight > rightHeight) ? leftHeight+1 : rightHeight+1;
		}
	}
	
	// Printing all the nodes at distance k
	public static void printNodes(Node root, int k) {
		if(root != null) {
			if(k == 0) {
				System.out.print(root.data +" ");
			}else {
				printNodes(root.left, k-1);
				printNodes(root.right, k-1);
			}	
		}
	}
	
	// space complexity: maximum width of the tree (level having max no. of nodes)
	public static void breadthFirst(Node root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		while(!q.isEmpty()) {
			Node current = q.poll();
			System.out.print(current.data +" ");
				
			if(current.left != null) {
				q.add(current.left);
			}
			if(current.right != null) {
				q.add(current.right);
			}
		}
	}
	
	// Number of total nodes in the tree
	public static int size(Node root) {
		if(root == null) {
			return 0;
		}else {
			int leftSize = size(root.left);
			int rightSize = size(root.right);
			return leftSize+rightSize+1; // 1 is for each root node
		}
	}
	
	// Number of total nodes in the tree
	public static int maximum(Node root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}else {
			
			int leftMax = maximum(root.left);
			int rightMax = maximum(root.right);
			return Math.max(Math.max(leftMax, rightMax), root.data);
			
//			return root.data > ((leftMax > rightMax) ? leftMax : rightMax) ? root.data : ((leftMax > rightMax) ? leftMax : rightMax);
//			if(root.data > leftMax && root.data > rightMax) {
//				return root.data;
//			}else if(leftMax > rightMax) {
//				return leftMax;
//			}else {
//				return rightMax;
//			}
		}
	}
	
	// Printing each level in new line
	public static void levelOrder2(Node root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null); // adding null after the end of each level
		
		while(q.size() > 1) { // the last element remains null
			Node current = q.poll();
			if(current == null) {
				System.out.println();
				q.add(null);
			}else {
				System.out.print(current.data +" ");
			
				if(current.left != null) {
					q.add(current.left);
				}
				if(current.right != null) {
					q.add(current.right);
				}
			}
		}
	}
	
	// Printing each level in new line (another approach)
	public static void levelOrder3(Node root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int count = q.size();
			// Printing each level
			for(int i = 0; i < count; i++) {
				Node current = q.poll();
				System.out.print(current.data +" ");
			
				if(current.left != null) {
					q.add(current.left);
				}
				if(current.right != null) {
					q.add(current.right);
				}
			}
			System.out.println();
		}
	}
	
	// Level order traversal (printing each nodes right to left)
	public static void levelOrder4(Node root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		while(!q.isEmpty()) {
			Node current = q.poll();
			System.out.print(current.data +" ");
			
			// change only the order of this 'if' condition i.e. adding right node first
			if(current.right != null) {
				q.add(current.right);
			}
			if(current.left != null) {
				q.add(current.left);
			}
			
		}
	}
	
	public static void leftView(Node root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			// Printing only one element for each level
			int count = q.size();
			for(int i = 0; i < count; i++) {
				Node current = q.poll();
				if(i == 0) { // for right view, change i = count-1
					System.out.print(current.data +" ");
				}
				
				if(current.left != null) {
					q.add(current.left);
				}
				if(current.right != null) {
					q.add(current.right);
				}
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
		Node root = null;
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.right.left =  new Node(50);
//		root.right.left.right =  new Node(777);
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
		
		System.out.print("\n\nHeight of the Tree: "+ heightOfTree(root));
		System.out.print("\nNodes at distance k: ");
		printNodes(root, 2);
		
		System.out.print("\nBreadth First/Level Order: ");
		breadthFirst(root);
		
		System.out.println("\nSize of the tree: "+ size(root));
		System.out.println("Maximum of the tree: "+ maximum(root));
		
		System.out.println("\nLevel Order 2 (Printing level by level): ");
		levelOrder2(root);
		System.out.println("\nLevel Order 3 (Printing level by level): ");
		levelOrder3(root);
		System.out.println("Level Order 4 (Printing right to left): ");
		levelOrder4(root);
		
		System.out.print("\n\nLeft View : ");
		leftView(root);

	}

}
