package stack;

public class StockSpan {
	
	static void stockSpan(int[] arr) {
		System.out.print("1 ");
		
		for(int i = 1; i < arr.length; i++) {
			int span = 1;
			for(int j = i-1; j >= 0 && arr[j] < arr[i]; j--) {
				span++;
			}
			System.out.print(span+" ");
		}
		System.out.println();
	}
	
	
	// span = index of current element - index of closest greater element on left OR
	// span = index of current element + 1
	// Applying the closest greatest to the left and pushing and popping the index
	static void stockSpanEfficient(int[] arr) throws StackUnderflowException {
		Stack stack = new Stack();
	
		for(int i = 0; i < arr.length; i++) {
			while(stack.top != null && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			if(stack.top == null) {
				System.out.print(i+1 +" ");
			}else {
				System.out.print(i-stack.peek() +" ");
			}
			stack.push(i);
		}
		System.out.println();
	}
	

	public static void main(String[] args) throws StackUnderflowException {

		int[] arr = {12, 14, 10, 15, 6, 10};
		int[] arr2 = {1, 2, 3, 4, 5, 6};
		int[] arr3 = {6, 5, 4, 3, 2, 1};
		
		stockSpan(arr);
		stockSpanEfficient(arr);
		stockSpan(arr2);
		stockSpanEfficient(arr2);
		stockSpan(arr3);
		stockSpanEfficient(arr3);

	}

}
