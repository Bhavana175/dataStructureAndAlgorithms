package com.workspace.learning.interviews.epampractice;

public class LinkedListRotate {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
      // 1,2,3,4,5,6
      // 5,6,1,2,3,4

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        int k =7;

        ListNode listNode = rotateRightByKSteps(n1, k);
        display(listNode);
    }

    private static void display(ListNode listNode) {
        ListNode aux = listNode;
        while (aux!=null){
            System.out.print(aux.data +"-> ");
            aux=aux.next;
        }
        System.out.print("null");
    }
    /*
    Time Complexity: 𝑂(n) n number of nodes
    Space Complexity: O(1), constant space.
     */

    private static ListNode rotateRightByKSteps(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode newHead = head;
        ListNode aux = head;

        int n= 0;
        while (aux!=null){
            n++;
            aux= aux.next;
        }
        k= k%n;
        if(k==0){
            // no rotation needed
            return head;
        }

        int pivot=0;
        aux = head;

        while (aux.next!=null && pivot!= n-k-1){
            aux=aux.next;
            pivot++;
        }

        newHead=aux.next;
        ListNode temp= newHead;
        aux.next=null;


        while (temp.next!=null){
            temp= temp.next;
        }

        temp.next=head;
        head=newHead;

        return head;
    }

}
