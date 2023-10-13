# Linked List

## Introduction

Linked list is a linear data structure used in computer science and programming. It is a collection of nodes, where each node contains two parts:

1. Data : This is the actual value or element stored in the node.
2. Reference (or Link) : This is a reference or pointer to the next node in the sequence (in a singly linked list) or both the next and previous nodes (in a doubly linked list).

The nodes in a linked list are connected sequentially, with each node pointing to the next one. This structure allows for efficient insertion and deletion of elements, especially when compared to Arrays or ArrayLists, where elements must be shifted to accommodate changes in the collection.

Linked list have a reference called as head and head will always point to the first element or to null if the list is empty.

## Different types of Linked Lists

1. Singly Linked List: In a singly linked list, each node points to the next node in the sequence. The last node typically points to null, indicating the end of the list.
2. Doubly Linked List: In a doubly linked list, each node has two references—one to the next node and one to the previous node. This allows for traversal in both forward and backward directions.
3. Circular Linked List: In a circular linked list, the last node points back to the first node, forming a closed loop.

## Applications of Linked List

Linked lists are used in various applications and can be implemented to create more complex data structures like Stacks, Queues, and Hash Tables.

They are particularly useful when we need dynamic memory allocation, as nodes can be allocated and deallocated as needed.

## Advantages and disadvantages of Linked List

Linked lists have some advantages over arrays, such as dynamic sizing, efficient insertions and deletions, and no need for contiguous memory allocation.

However, they also have some disadvantages, such as slower random access times and increased memory overhead due to the storage of references/pointers. We won't be able to access any node at random (as we do in the array by index).