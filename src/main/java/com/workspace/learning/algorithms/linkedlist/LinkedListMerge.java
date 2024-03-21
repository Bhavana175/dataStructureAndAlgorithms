package com.workspace.learning.algorithms.linkedlist;

public class LinkedListMerge {

    //https://leetcode.com/problems/merge-in-between-linked-lists/?envType=daily-question&envId=2024-03-20

    public static void main(String[] args) {

        //[10,1,13,6,9,5]
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(13);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode list1 = n1;

        ListNode m1 = new ListNode(1000000);
        ListNode m2 = new ListNode(1000001);
        ListNode m3 = new ListNode(1000002);

        m1.next = m2;
        m2.next = m3;

        ListNode list2 = m1;

        LinkedListMerge obj = new LinkedListMerge();
        obj.mergeInBetween(list1, 3, 4, list2);

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode aux = list1;
        ListNode temp = aux;
        ListNode aux2 = list2;
        int counter = 0;

        while (aux.next != null && counter != a - 1) {
            aux = aux.next;
            counter++;
        }
        temp = aux;

        while (aux.next != null && counter != b + 1) {
            aux = aux.next;
            counter++;
        }
        temp.next = list2;
        while (aux2.next != null) {
            aux2 = aux2.next;
        }
        aux2.next = aux;

        return list1;
    }

}

class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
