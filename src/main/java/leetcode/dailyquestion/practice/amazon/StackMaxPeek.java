package leetcode.dailyquestion.practice.amazon;

import java.util.Stack;

public class StackMaxPeek {

    private Stack<Integer> stack;
    private Stack<Integer> stackMax;

    public StackMaxPeek() {
        this.stack = new Stack<>();
        this.stackMax = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!stackMax.isEmpty()) {
            stackMax.push(Math.max(stackMax.peek(), val));
        } else stackMax.push(val);
    }

    public int pop() {
        stackMax.pop();
        return stack.pop();
    }

    public int maxPeek() {
        return stackMax.peek();
    }

    public int maxPop() {
        int maxVal = stackMax.peek();
        Stack<Integer> buffer = new Stack<>();
        while (!stack.isEmpty() && stack.peek() != maxVal) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return maxVal;
    }

    public void display(){
        stack.forEach((v)->System.out.print(v+" "));
        System.out.println();
        stackMax.forEach((v)->System.out.print(v+" "));
        System.out.println();
    }

}

class Main {
    public static void main(String[] args) {

        StackMaxPeek stackMaxPeek = new StackMaxPeek();
        stackMaxPeek.push(2);
        stackMaxPeek.push(4);
        stackMaxPeek.push(7);
        stackMaxPeek.push(1);
        stackMaxPeek.push(3);
        stackMaxPeek.push(5);
        stackMaxPeek.push(1);
        stackMaxPeek.push(2);

        stackMaxPeek.display();
        System.out.println("pop "+stackMaxPeek.pop());
        stackMaxPeek.display();
        System.out.println("max peek "+stackMaxPeek.maxPeek());
        stackMaxPeek.display();
        System.out.println("max pop "+stackMaxPeek.maxPop());
        stackMaxPeek.display();
        System.out.println("max peek "+stackMaxPeek.maxPeek());
        stackMaxPeek.display();
        System.out.println("max pop "+stackMaxPeek.maxPop());
        stackMaxPeek.display();
    }

}