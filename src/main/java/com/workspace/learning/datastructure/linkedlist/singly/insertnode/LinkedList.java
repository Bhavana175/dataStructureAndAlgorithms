package com.workspace.learning.datastructure.linkedlist.singly.insertnode;

import com.workspace.learning.datastructure.linkedlist.singly.Node;

public class LinkedList {

    private Node head;

    private int length;

    public LinkedList() {
        this.length = 0;
    }

    public synchronized Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    /**
     * Insert Node at the beginning
     */

    public synchronized void insertAtBegin(Node node) {
        // O(1)
        node.next = head;
        head = node;
        length++;
    }

    /**
     * Insert Node at the End
     * @param node
     */

    public synchronized void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node aux = head;
            while (aux.getNext() != null) {
                aux = aux.next;
            }
            aux.next = node;
        }
        length++;
    }

    /**
     * Insert value at given position in linked-list
     * @param data
     * @param position
     */
    public void insert(int data, int position) {
        Node dataNode = new Node(data);
        int counter = 1;
        Node aux = head;
        //fix position
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }
        //only element
        if (head == null) {
            head = dataNode;
        } else {
            if (position == 0) {
                dataNode.next = head;
                head = dataNode;
            } else {
                while (counter != position) {
                    aux = aux.next;
                    counter++;
                }
                dataNode.next = aux.next;
                aux.next = dataNode;
            }
        }
        length++;
    }

    public void display() {
        Node aux = head;
        System.out.println();
        while (aux != null) {
            System.out.print(" " + aux.data + " -->");
            aux = aux.next;
        }
        System.out.print(" " + null);
    }
}
