package com.workspace.learning.datastructure.linkedlist.doubly;

public class DoublyLinkedList {

    DLLNode head;

    DLLNode tail;

    int length;

    public DoublyLinkedList() {
    }

    public DLLNode getHead() {
        return head;
    }

    public void setHead(DLLNode head) {
        this.head = head;
    }

    public DLLNode getTail() {
        return tail;
    }

    public void setTail(DLLNode tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int get(int position) {
        return Integer.MIN_VALUE;
    }

    /**
     * Add value at Beginning
     */

    public void addValueAtFront(int value) {

        DLLNode dllNode = new DLLNode(value);

        if (head == null) {
            head = dllNode;
            tail = dllNode;
        } else {
            dllNode.next = head;
            head.prev = dllNode;
            head = dllNode;
        }
        length++;
    }

    public void addValueAtEnd(int value) {
        DLLNode dllNode = new DLLNode(value);
        if (head == null) {
            head = dllNode;
            tail = dllNode;
        } else {
            tail.next = dllNode;
            dllNode.prev = tail;
            tail = dllNode;
        }
        length++;
    }

    public void addValueAtPosition(int value, int position){
        DLLNode node = new DLLNode(value);
        int counter=0;
        DLLNode aux= head;
        //fix position
        if(position<0){
            position=0;
        }
        if (position>length){
            position=length;
        }

        if(head==null){
            head=node;
            tail=node;
        }else {
              if (position==0){
                  node.next=aux;
                  aux.prev=node;
                  head=node;
              }else {

                  while ( counter<position-1){
                      aux=aux.next;
                      counter++;
                  }
                  if(aux.next != null){
                      node.next = aux.next;
                      aux.next.prev = node;
                      aux.next=node;
                      node.prev=aux;
                  }else {
                      aux.next=node;
                      node.prev=aux;
                      tail=node;
                  }


              }


        }

        length++;

    }
    public void clearDLL(){
        head=null;
        tail=null;
        length=0;

    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
