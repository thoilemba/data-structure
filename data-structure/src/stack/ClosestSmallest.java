package stack;

import java.util.ArrayList;

public class ClosestSmallest {
	
	/*
	 *Algorithm :
		1. Create an empty stack.
		2. Loop through the elements of the array.
		3. While the stack is not empty and the top element of the stack
		  is greater than the current element, pop the stack.
		4. If the stack is empty, print -1 as there is no smaller element
		  to the left of the current element.
		5. Else, print the top element of the stack as it is the closest
		  and smallest element to the left of the current element.
		6. Push the current element to the stack.
	 */
	
	// Time complexity - O(n2)
	static void closestSmallest(int[] arr) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(-1);
		
		for(int i = 1; i < arr.length; i++) {
			int min = -1;
			for(int j = i-1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					min = arr[j];
					break;
				}
			}
			result.add(min);
		}
		
		for(int item : result) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	
	// OR
	// Using Stack - O(n)
	static void closestSmallestEfficient2(int[] arr) throws StackUnderflowException {
		Stack stack = new Stack();
		
		for(int i = 0; i < arr.length; i++) {
			while(stack.top != null && stack.peek() > arr[i]) {
				stack.pop();
			}
			if(stack.top == null) {
				System.out.print("-1 ");
			}else {
				System.out.print(stack.peek() +" ");
			}
			stack.push(arr[i]);
		}
		System.out.println();
	}
	

	public static void main(String[] args) throws StackUnderflowException {
		int[] arr = {5, 7, 3, 12, 9};
		int[] arr2 = {5, 4, 3, 2, 1};
		int[] arr3 = {1, 2, 3, 4, 5};
		
		closestSmallest(arr);
		closestSmallestEfficient2(arr);
		closestSmallest(arr2);
		closestSmallestEfficient2(arr2);
		closestSmallest(arr3);
		closestSmallestEfficient2(arr3);
		
	}

}
 