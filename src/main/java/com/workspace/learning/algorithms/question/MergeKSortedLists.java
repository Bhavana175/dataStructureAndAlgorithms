package com.workspace.learning.algorithms.question;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode[] listNodes = new ListNode[3];

        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(2);
        listNodes[1].next.next = new ListNode(8);

        listNodes[0] = new ListNode(2);
        listNodes[0].next = new ListNode(6);
        listNodes[0].next.next = new ListNode(7);

        MergeKSortedLists obj = new MergeKSortedLists();

        ListNode listNode = obj.mergeKSortedList(listNodes);

    }

    private ListNode mergeKSortedList(ListNode[] listNodes) {
        ListNode head_0 = null;

        //check id node list is not null
        // need head node for all the list
        //need to compare val of head node
        //equal = n1->m1->o1
        //not equal which one is min m1(new list), move head_m and again compare
        //add nodes to new list

        for (int i = 0; i < listNodes.length; i++) {

        }

        return head_0;
    }
}
class ListNode{

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
