package com.workspace.learning.datastructure.linkedlist.singly.insertnode;

import com.workspace.learning.datastructure.linkedlist.singly.Node;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        Node firstNode = new Node(20);
        Node forurthNode = new Node(80);
        Node fifthNode = new Node(100);
        Node sixthNode = new Node(120);

        linkedList.insertAtEnd(fifthNode);
        linkedList.insertAtBegin(firstNode);
        System.out.println(linkedList.getHead());
        linkedList.display();
        linkedList.insertAtBegin(sixthNode);
        linkedList.insertAtEnd(forurthNode);
        linkedList.display();
        linkedList.insert(30,3);
        linkedList.display();
        linkedList.insert(31,-10);
        linkedList.display();
        linkedList.insert(32,12);
        linkedList.display();
        linkedList.insert(33,0);
        linkedList.display();
        linkedList.insert(35,1);
        linkedList.display();
        linkedList.insert(35,9);
        linkedList.display();
        System.out.println();

        System.out.println("length :"+linkedList.getLength());
    }

}
