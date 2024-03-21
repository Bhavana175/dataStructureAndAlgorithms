package com.workspace.learning.datastructure.linkedlist.doubly;

public class DLLMain {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        System.out.println(doublyLinkedList.getHead());
        System.out.println(doublyLinkedList.getTail());
        System.out.println(doublyLinkedList.getLength());
        doublyLinkedList.addValueAtFront(25);
        doublyLinkedList.addValueAtFront(30);
        System.out.println(doublyLinkedList.getHead());
        System.out.println(doublyLinkedList);
        doublyLinkedList.addValueAtEnd(100);
        System.out.println(doublyLinkedList);
        doublyLinkedList.clearDLL();
        doublyLinkedList.addValueAtEnd(9);
        System.out.println(doublyLinkedList);
        doublyLinkedList.addValueAtPosition(105,-2);
        System.out.println(doublyLinkedList);
        doublyLinkedList.clearDLL();
        doublyLinkedList.addValueAtPosition(300, 0);
        doublyLinkedList.addValueAtPosition(400, 1);
        System.out.println(doublyLinkedList);
        doublyLinkedList.addValueAtPosition(500,1);
        System.out.println(doublyLinkedList);

    }

}
