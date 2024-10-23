# Doubly Linked List

In a doubly linked list, each node contains three parts :
 1. Previous - points to previous node.
 2. Data - the actual data.
 3. Next - points to the next node.
 
Doubly linked list have two references/pointers - head and tail. Head point to the first element and tail points to the last element.

### Tail Reference
Some implementation of doubly linked list does not have the tail reference.

The decision to include a tail reference in a doubly linked list should be based on the trade-offs between efficiency, simplicity, memory usage, and the specific needs of the program. If our program  frequently involves operations at the end of the list, having a tail reference can be beneficial, but in other cases, we may choose to omit it to simplify our implementation.

### Advantages  of Doubly Linked List :

 - Two-way navigation: The doubly linked list structure allows for navigation in both forward and 	backward directions, making it easier to traverse the list.
 - Time complexity of accessing last element is O(1) using the tail reference.
 - Used in Stack, Heap, Binary Tree implementation.


### Disadvantages  of Doubly Linked List :

 - Each node requires extra memory to store two references (next and previous).
 - It requires more manipulation of pointers which can result in more complex code and potential      	bugs.