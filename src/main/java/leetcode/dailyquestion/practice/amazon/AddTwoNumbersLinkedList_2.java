package leetcode.dailyquestion.practice.amazon;

import com.workspace.learning.datastructure.linkedlist.singly.LinkedList;

public class AddTwoNumbersLinkedList_2 {
    public static void main(String[] args) {

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int n=0;
        int m =0;

        ListNode aux = l1;
        ListNode aux2 = l2;
        while (aux!=null){
            n++;
            aux = aux.next;
        }
        while (aux2!=null){
            m++;
            aux2 = aux2.next;
        }


return  null;


    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
