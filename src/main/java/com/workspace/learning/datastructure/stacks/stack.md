

What is Stack?
Stack is a simple data structure used for storing data.
In a stack, the order in which the data arrive is important.

Stack is an ordered list, in which insertion and deletion are done at one end, called top.

push: when an element is inserted.
pop: when an element is removed. 

underflow : exception when trying to pop an empty stack.
overflow: exception when trying to push an element in full stack.

Main Stack operations

void push(int data)
int pop()

other operations
int top()
int size()
int isEmpty()
int isFull()


Direct Implementation
1. Balancing of symbols (e.g "([]{}())")
2. Infix to postfix conversion (e.g infix = "(A+B)*C-D"  postfix = "AB+C*D-")
3. Undo sequence in text editor.
4. Matching tags in HTML and XML.
5. Page visited history in Web browser.
6. Evaluation of Postfix expression.
