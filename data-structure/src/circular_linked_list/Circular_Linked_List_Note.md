# Circular Linked List

A circular linked list is a special type of linked list in which the last node is connected to the first node, creating a continuous loop. There is no NULL at the end.

### There are basically two types of circular linked list

1. Circular Singly Linked List - The address of the last node consists of the address of the first node.

2. Circular Doubly Linked List - In addition to the last node storing the address of the first node, the first node will also store the address of the last node.
It has properties of both doubly linked list and circular linked list in which two consecutive elements are linked or connected by the previous and next pointer and the last node points to the first node by the next pointer and also the first node points to the last node by the previous pointer.


### Advantages of Circular Linked Lists

- The NULL assignment is not required because a node always points to another node.
- The starting point can be set to any node. We just need to stop when the first visited node is visited 	again.
- Traversal from the first node to the last node is quick.

### Disadvantages of circular linked list

- It is possible for the code to go into an infinite loop if it is not handled carefully.
- Debugging circular linked lists can be more challenging. It is harder to find the end of the list and 	control the loop.
- Performance can be slower than other data structures in certain cases, such as when the list needs to 	be sorted or searched.