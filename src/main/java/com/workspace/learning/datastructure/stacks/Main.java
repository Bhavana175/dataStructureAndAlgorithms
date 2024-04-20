package com.workspace.learning.datastructure.stacks;

public class Main {

    public static void main(String[] args) throws Exception {

        FixedSizeArrayStack stack = new FixedSizeArrayStack();

        stack.push(10);
        stack.push(11);
        stack.push(12);

        System.out.println(stack.size());
        System.out.println(stack.pop());

        System.out.println(stack.size());
        System.out.println(stack.pop());

        System.out.println(stack.size());
        System.out.println(stack.pop());

        System.out.println(stack.size());


        LinkedStack linkedStack = new LinkedStack();

        linkedStack.push(111);
        linkedStack.push(20);
        linkedStack.push(10);
        linkedStack.push(5);

        System.out.println(linkedStack.peek());
        System.out.println(linkedStack.isEmpty());
        System.out.println(linkedStack.size());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.size());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.size());
    }

}
