package stack;

public class Infix {
	
	static int precedence(char ch) {
		if(ch == '^') {
			return 3;
		}
		else if(ch == '*' || ch == '/') {
			return 2;
		}else if(ch == '+' || ch == '-') {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	static String toPostfix(String s) throws StackUnderflowException {
		Stack stack = new Stack();
		String result = "";
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isLetter(ch)) {
				result = result+ch;
			}else if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result += (char)stack.pop();
				}
				stack.pop(); // removing the opening bracket '('
			}else {
//				if(!stack.isEmpty() && precedence(ch) > precedence((char)stack.peek())) {
//					stack.push(ch);
//				}else {
					while(!stack.isEmpty() && precedence(ch) <= precedence((char)stack.peek())) {
						result += (char)stack.pop();
					}
					stack.push(ch);
//				}
			}
		}
		
		while(!stack.isEmpty()) {
			result += (char)stack.pop();
		}
		
		return result;
	}
	
	
	static String toPrefix(String s) throws StackUnderflowException{
		String reverse = "";
		
		// Reverse the String along with switching '(' and ')' and vice versa.
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) == '(') {
				reverse += ')';
			}else if(s.charAt(i) == ')') {
				reverse += '(';
			}else {
				reverse += s.charAt(i);
			}
		}
		
		// Infix to Postfix Conversion
		Stack stack = new Stack();
		String result = "";
		
		for(int i = 0; i < reverse.length(); i++) {
			char ch = reverse.charAt(i);
			if(Character.isLetter(ch)) {
				result = result+ch;
			}else if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result += (char)stack.pop();
				}
				stack.pop(); // removing the opening bracket '('
			}else {
				while(!stack.isEmpty() && precedence(ch) < precedence((char)stack.peek())) {
					result += (char)stack.pop();
				}
				stack.push(ch);
			}
		}
		
		while(!stack.isEmpty()) {
			result += (char)stack.pop();
		}
		
		
		String reverse2 = "";
		// Reversing the Postfix result
		for(int i = result.length()-1; i >= 0; i--) {
			reverse2 += result.charAt(i);
		}
		
		return reverse2; // this is the final Prefix form
	}

	
	public static void main(String[] args) throws StackUnderflowException {
		
		String s = "a+b*(c-d)/e";
		System.out.println("Infix : "+ s);
		System.out.println("Postfix : "+ toPostfix(s));
		System.out.println("Prefix : "+ toPrefix(s));
		System.out.println();
		
		String s2 = "x+y*z/w+u";
		System.out.println("Infix : "+ s2);
		System.out.println("Postfix : "+ toPostfix(s2));
		System.out.println("Prefix : "+ toPrefix(s2));
		System.out.println();
		
		System.out.println("Infix : a*b/c");
		System.out.println("Postfix : "+ toPostfix("a*b/c"));
		System.out.println("Prefix : "+ toPrefix("a*b/c"));
	
	}

}

