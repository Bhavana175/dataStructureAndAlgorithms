package com.workspace.learning.datastructure.stacks;

import lombok.Data;

public class LinkedStack {

    int length;

    ListNode top;

    public LinkedStack() {
        this.length = 0;
        this.top = null;
    }

    public void push(int data) {
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }

    public int pop() throws Exception {

        if(top == null){
            throw new Exception("Empty stack");
        }
        ListNode aux = top;
        top = aux.next;
        aux.next=null;
        length--;
        return aux.data;
    }

    public int peek() throws Exception {

        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }
        return top.data;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int size(){
        return length;
    }

}

@Data
class ListNode {

    int data;

    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

}
