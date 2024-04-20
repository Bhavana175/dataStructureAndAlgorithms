package com.workspace.learning.algorithms.linkedlist;

public class PrintAlternateNode {

    public static void main(String[] args) {

        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);
        ListNode n5= new ListNode(5);
        ListNode n6= new ListNode(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        PrintAlternateNode obj = new PrintAlternateNode();
        obj.printAlternateNode(n1);
    }

    private void printAlternateNode(ListNode head) {
        ListNode aux = head;
        while (aux.next!=null){
            System.out.println(aux.val);
            aux = aux.next;
            if (aux.next!=null) {
                aux = aux.next;
            }
        }

    }
}
