package test;

// Finding the length of an Array and String using using the built-in length method
public class Length {
	
	
	static public void arrayLength(int[] arr) {
		int count = 0;
		int index = 0;
		try {
			while(true) {
				@SuppressWarnings("unused")
				int temp = arr[index];
				index++;
				count++;
			}
		}catch(Exception e) {
			System.out.println("Reached end of the Array.");
		}finally {
			System.out.println(count);
		}
	}
	
	static public void arrayLength2(int[] arr) {
		int count = 0;
		
		for(@SuppressWarnings("unused") int item : arr) {
			count++;
		}
		System.out.println(count);
		
	}
	
	static public void stringLength(String str) {
		int count = 0;
		int index = 0;
		try {
			while(true) {
				@SuppressWarnings("unused")
				char temp = str.charAt(index);
				index++;
				count++;
			}
		}catch(Exception e) {
			System.out.println("Reached end of the String.");
		}finally {
			System.out.println(count);
		}
	}
	
	
	static public void stringLength2(String str) {		
		int count = 0;
		@SuppressWarnings("unused")
		int index = 0;
		
		try {
			// Iterate through the string until a null character is encountered.
			while (str.getBytes()[count] != 0) {
				count++;
			}
		}catch(Exception e) {
			System.out.println("Reached end of the String.");
		}finally {
			System.out.println(count);
		}
	}

	public static void main(String[] args) {

		System.out.println("Length of the Array : ");
		int[] arr = {1, 2, 3, 4, 5};
		arrayLength(arr);
		arrayLength2(arr);
		
		System.out.println("Length of the String : ");
		String s = "Hello";
		stringLength(s);
		stringLength2(s);
		
	}

}
