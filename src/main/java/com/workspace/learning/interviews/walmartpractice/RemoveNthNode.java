package com.workspace.learning.interviews.walmartpractice;

public class RemoveNthNode {

    /*
    given the head of the linked list remove nth node from the end
    of the linked list and return its head
     */
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Node output = removeNthNode(n1, 2);
        display(output);

    }

    private static void display(Node output) {

        Node aux = output;
        while (aux!=null){
            System.out.print(aux.val +" ---> ");
            aux=aux.next;
        }
        System.out.print("null");
    }

    private static Node removeNthNode(Node head, int k) {
        int n=0;
        if (head !=null) {
            n=1;
        }
        Node aux = head;
        //calculate length
        while (aux.next!=null){
            n++;
            aux= aux.next;
        }

        // remove n-k+1 th node
        int count =1;
        aux = head;
        while (aux.next!=null && count< n-k){
            count++;
            aux = aux.next;
        }
        // 1 2 3 4 5
        Node temp = aux;
        aux = aux.next;
        temp.next = aux.next;
        aux.next=null;

        return head;
    }

}
class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
