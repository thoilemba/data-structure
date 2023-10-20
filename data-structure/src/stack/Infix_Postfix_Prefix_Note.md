# Infix, Prefix, Postfix

**Infix** : Operator lies between the operands. Eg. a+b
**Prefix** : Operator lies before the operands. Eg. +ab
**Postfix** : Operator lies after the operands. Eg. ab+


**Precedence rule** : It is a rule that defines the order in which different operators are evaluated in an expression that contains more than one operator.

**Associativity** : It also defines the order in which operations are performed when multiple operators of the same precedence appear in an expression. Eg. 5+3-2; left-right.


Precedence and Associativity :

1. Bracket : (), {}, []  :  innermost to outer
2. Exponent : ^, **, $   :  Right to Left
3. Multiplication, Division, Modulus : *, /, % : Left to Right
4. Addition, Subtraction : +, - : Left to Right


### Infix to Postfix Algorithm

1. Initialize an empty stack and an empty output string.
2. Scan the infix expression from left to right, one character at a time.
3. If the character is an operand (a letter or a number), append it to the output string.
4. If the character is an opening parenthesis ‘(’, push it onto the stack.
5. If the character is a closing parenthesis ‘)’, pop and append all the operators from the stack to the output string until an opening parenthesis ‘(’ is encountered. Pop and discard the opening parenthesis from the stack. That is, remove the ‘(’ from stack and do not add it to the postfix expression
6. Finally, the character is an operator (+, -, *, /, ^) then
a. Repeatedly pop from stack and add each operator ( popped from the stack) to the postfix expression which has equal or higher precedence than O
b. Push the operator to the stack..
7. Repeat steps 3 to 6 until all characters in the infix expression are scanned.
8. Pop and append all the remaining operators from the stack to the output string.
9. Return the output string as the postfix expression.

### Infix to Prefix Algorithm

- Step 1: Reverse the infix string. While reversing the string left and right parentheses must interchange.
- Step 2: Obtain the postfix expression of the expression obtained from Step 1 using the above given postfix algorithm with slight change in **Step 6.** IF an operator is encountered, then a. Repeatedly pop from stack and add each operator ( popped from the stack) to the postfix expression which has ~~equal or~~ higher precedence than O.
- Step 3: Reverse the postfix expression to get the prefix expression.

### Different Result in Prefix (maybe also in Postfix)
I found that conversion of infix to prefix in online converter have different result (in the operators). It is due to the associativity (one applies the associativity and another not). But the end result after calculating the expression will be same.

For example, infix = `a*b/c` = `(a*b)/c`  OR `a*(b/c)`. 

`a*b/c` in Prefix = `/*abc` OR `a/bc`

Here are the two online converter :

https://raj457036.github.io/Simple-Tools/prefixAndPostfixConvertor.html

https://www.calcont.in/Conversion/infix_to_prefix



