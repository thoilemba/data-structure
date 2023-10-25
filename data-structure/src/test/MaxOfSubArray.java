package test;

import java.util.Scanner;
import dequeue.DeQueue;


public class MaxOfSubArray {
	
	// Find the maximum number of all the sub-arrays of size k
	static public void maxOfSubArray2(int[] arr, int k) {
		DeQueue deque = new DeQueue(); // Initialize a dequeue to store indices
		//	ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>(); // Java's built-in Dequeue
		
		// Process the first sub-array of size k
		for(int i = 0; i <k; i++) {
			// Remove elements from the back of the dequeue if they are smaller than the current element
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offerLast(i); // Add the current index to the dequeue
		}
		
		// Process the remaining sub-arrays
		for(int i = k; i < arr.length; i++) {
			// Print the maximum element for the current sub-array (at the front of the dequeue)
			System.out.println(arr[deque.peekFirst()]);
			
			// removing the element which is not the part of the sub-array
			while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
				deque.pollFirst();
			}
			// removing the element which is smaller
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offerLast(i); // Add the current index to the dequeue
		}
		// Print the maximum element of the last sub-array
		System.out.println(arr[deque.peekFirst()]);
	}

	public static void main(String[] args) {
		System.out.print("Enter the size of the Array : ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
//		12 10 9 15 20 10 8
		System.out.println("Enter the elements of the Array : ");
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = 3;
		maxOfSubArray2(arr, k);
		
		sc.close();
	}

}
