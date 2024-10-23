package stack;

public class ValidateParenthesis {
	
	
	static boolean balancedParenthesis(String s) throws StackUnderflowException {
		
		Stack tempStack = new Stack();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				tempStack.push(ch);
			}
			else if(!tempStack.isEmpty() &&
			   ch == ')' && tempStack.peek() == '(' ||
			   ch == '}' && tempStack.peek() == '{' ||
			   ch == ']' && tempStack.peek() == '[') {
					tempStack.pop();
			}else {
				return false;
			}
		}
		
//		System.out.println(tempStack.size);
		if(tempStack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) throws StackUnderflowException {

		System.out.println(balancedParenthesis("([{}])"));
		System.out.println(balancedParenthesis("([{"));
		System.out.println(balancedParenthesis(")}]"));
		System.out.println(balancedParenthesis("{)(]"));
		System.out.println(balancedParenthesis("(){}[]"));
	}

}
