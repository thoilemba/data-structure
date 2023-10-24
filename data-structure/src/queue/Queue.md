# Queue

**A queue is a linear data structure in computer science that follows the First-In-First-Out (FIFO) principle which means that the first element added to the queue is the first one to be removed.\**

Queue has two pointers : **FRONT** and **REAR**.

- FRONT holds the first element of the queue.
- REAR holds the last element of the queue.

### Types of Queue

There are four different types of queues:

- Simple Queue
- Circular Queue
- Priority Queue
- Double Ended Queue

**Simple Queue**: In a simple queue, insertion takes place at the rear and removal occurs at the front. It strictly follows the FIFO (First in First out) rule.


**Circular Queue**: In a circular queue, the last element points to the first element making a circular link.
The main advantage of a circular queue over a simple queue is better memory utilization. If the last position is full and the first position is empty, we can insert an element in the first position. This action is not possible in a simple queue.


**Priority Queue**: Each element is associated with a **priority value**. And, elements are served on the basis of their priority. That is, higher priority elements are served first.
Priority queue can be implemented using an array, a linked list, a heap data structure, or a binary search tree. Among these data structures, heap data structure provides an efficient implementation of priority queues.

**DeQueue** (Double Ended Queue): In a double ended queue, insertion and removal of elements can be performed from either from the front or rear. Thus, it does not follow the FIFO (First In First Out) rule.


### Application of Queue

- **Task Scheduling:** In operating systems, queues are used to manage processes and tasks. The next task to be executed is typically the one at the front of the queue.
- **Breadth-First Search (BFS):** Queues are used in graph algorithms like BFS to explore nodes level by level.
- **Data Buffering:** Queues can be used to manage data buffering in applications like streaming media and communication systems.
- **Order Processing:** In e-commerce and order processing systems, orders are placed in a queue and processed in the order they were received.
- **Task Management:** In task management applications, tasks can be organized and processed using queues.

### **Advantages of Queues**

- Operations such as insertion and deletion can be performed with ease as it follows the first in first out rule.
- Queues are useful when a particular service is used by multiple consumers.
- Queues are excellent for scenarios where ordered processing is crucial.

### **Disadvantages of Queues**
1. **Limited Access:** Access to elements in the middle of a queue is limited. We cannot easily access or remove elements in the middle without dequeuing previous elements.
2. **Inefficient for Random Access:** Queues are inefficient for random access to elements.
3. **Memory Overhead:** Implementing a queue may involve some memory overhead, especially if using a linked list representation.
4. **Complexity of Priority Queues:** While standard queues follow the FIFO principle, priority queues add complexity by allowing elements with different priorities. Priority queues often require more data structures, like binary heaps.
5. **Potential for Resource Blocking:** In systems where a queue is used to manage tasks or processes, resource contention or task delays can occur if not managed properly.
