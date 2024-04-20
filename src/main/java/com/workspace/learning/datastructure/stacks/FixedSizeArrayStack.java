package com.workspace.learning.datastructure.stacks;

public class FixedSizeArrayStack {
    int cap = 10;
    int top =-1;
    int [] stack;

    //initialize with given capacity
    public FixedSizeArrayStack(int cap) {
        this.cap = cap;
        stack = new int[cap];
    }
    //initialize with default capacity
    public FixedSizeArrayStack() {
        stack = new int[cap];
    }
    public void push(int data) throws Exception {
        if(size()==cap){
            throw new Exception("stack is full");
        }
        stack[++top]=data;

    }
    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        int temp = stack[top];
        stack[top]=Integer.MIN_VALUE;
        top--;
        return temp;
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top < 0;
    }
    public int getTop(){
        return top;
    }

}
