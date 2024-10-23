# Binary Tree

**Binary Tree** is a tree data structure where each node has at most 2 children.

Example Tree :

               10
               / \
              20   30
             /     / \
            40    50 60
            
**Breadth First or Level Order** - Traverse from top to bottom (level by level).

**Depth First** - It has three types of traversal :

1. **Inorder Traversal** - Left, Root, Right.
2. **Preorder Traversal** - Root, Left, Right.
3. **Postorder Traversal** - Left, Right, Root.

### Algorithm for Inorder Traversal without using recursion

1.  Check if the root node is **`null`**. If it is, return.
2. Create an empty stack **`stack`** to store tree nodes.
3. Initialize a **`current`** variable to the root node of the binary tree.
4. While **`current`** is not **`null`** or the stack is not empty (indicating there are nodes to process):
a. While **`current`** is not **`null`**, do the following:
i. Push **`current`** onto the **`stack`**.
ii. Update **`current`** to its left child (moving to the left subtree).
b. Pop a node from the **`stack`** and set it as **`current`**.
c. Process the node (e.g., print its value).
d. Update **`current`** to its right child (moving to the right subtree).

### Algorithm for Preorder Traversal without using recursion

1. Create an empty **`stack`** to store tree nodes.
2. Push the root node onto the **`stack`**.
3. While **`stack`** is not empty, repeat the following steps:
a. Pop a node from the **`stack`** and process it (e.g., print its value).
b. If the right child of the popped node (current) exists, push it onto the `stack`.
c. If the left child of the popped node (current) exists, push it onto the `stack`.
4. The algorithm completes when the **`stack`** is empty, and all nodes have been processed.

### Algorithm for Postorder Traversal without using recursion

1. Create two stacks: **`stack1`** and **`stack2`**.
2. Push the root node onto **`stack1`**.
3. While **`stack1`** is not empty, repeat the following steps:
a. Pop a node from **`stack1`** and push it onto **`stack2`**.
b. If the popped node has a left child, push the left child onto **`stack1`**.
c. If the popped node has a right child, push the right child onto **`stack1`**.
4. After the traversal is complete, **`stack2`** contains the nodes in a postorder traversal.
5. Pop nodes from **`stack2`** and process each node as desired (e.g., print its value).
6. Continue this process until **`stack2`** is empty.
7. The algorithm completes when all nodes of the binary tree have been processed in a postorder traversal.


### Time and Space complexity for traversal

The non-recursive version of the code for traversal has the same time and space complexity as the non-recursive version. The time complexity is O(n), and the space complexity is O(h) in the worst case, where "h" represents the height of the tree.

**Time Complexity:**
The time complexity of the code is **O(n)**, where **n** is the number of nodes in the binary tree. This is because we visit each node exactly once.

**Space Complexity:**
The space complexity is **O(h)**, where **h** is the height of the binary tree. In the worst case, when the binary tree is skewed (i.e., it resembles a linked list), the stack can have at most **h** nodes, as it stores nodes along the left branch of the tree. In a balanced binary tree, the space complexity is **O(log n)**, where **n** is the number of nodes in the tree.