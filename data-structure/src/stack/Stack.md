# Stack

**A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle, which means that the last element added to the stack is the first one to be removed.**

Stacks are used for managing data in a way that ensures that the most recently added data is the first to be processed.

### Operations of Stack

1. **push() :** Adding an item to the top of the stack.
2. **pop() :** Removing the top item from the stack.
3. **peek() :** Getting the top item without removing it.
4. **isEmpty() :** Checking whether the stack is empty or not.
5. **IsFull (only in static stack)** : Check if the stack is full.
6. **size() :** The number of items in the stack.

### Applications of Stack

- **Mathematical expression:** Stacks are used to evaluate mathematical expressions, such as infix, postfix, and prefix expressions. They are also used to convert one expression to another.
- **Backtracking:** Stacks are used in backtracking algorithms to keep track of the path taken to reach a particular point in the algorithm.
- **Function call:** Stacks are used to keep track of function calls and and their associated data.
- **Memory Management:** Stacks are used in memory management to allocate and deallocate memory for variables and data structures.
- **Browser History:** Stacks are used to maintain the backward and forward navigation history in web browsers.
- **Expression Matching:** Stacks are used for matching parentheses, brackets, and tags in various parsing and validation tasks.

### Advantages of Stack

- **Easy implementation:** Stack data structure is easy to implement using arrays or linked lists, and its operations are simple to understand and implement.
- **Fast access time:** Stack data structure provides fast access time for adding and removing elements as the elements are added and removed from the top of the stack.
- **Efficient operations** : Stack’s operation takes O(1) time complexity.

### Disadvantages of Stack

- No random access: Stack data structure does not allow for random access to its elements, and it only allows for adding and removing elements from the top of the stack.
- Not suitable for certain applications: Stack data structure is not suitable for applications that require accessing elements in the middle of the stack, like searching or sorting algorithms.
- Stack overflow and underflow : Stack data structure can result in stack overflow (for static stack) if too many elements are pushed onto the stack, and it can result in stack underflow if too many elements are popped from the stack.