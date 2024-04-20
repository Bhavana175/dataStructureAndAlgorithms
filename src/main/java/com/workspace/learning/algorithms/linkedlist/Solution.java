package com.workspace.learning.algorithms.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * <p>
 * l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 */
class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();

        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(6);

        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        //6342
        // 465
        //6807
        //ans 7086

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l2.next = l22;
        l22.next = l23;

        System.out.println(" output : " + obj.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aux1 = l1;
        ListNode aux2 = l2;
        ListNode head = new ListNode();
        ListNode aux3 = head;
        int sum = 0;
        int carry = 0;

        while (aux1 != null || aux2 != null) {
            sum=0;

            if (aux1 != null) {
                sum += aux1.val;
                aux1 = aux1.next;
            }
            if (aux2 != null) {
                sum += aux2.val;
                aux2 = aux2.next;
            }
            sum += carry;
            aux3.next = new ListNode(sum % 10);
            carry = sum / 10;
            aux3 = aux3.next;

        }
        if (carry != 0) {
            aux3.next = new ListNode(carry);
        }

        return head.next;

    }
}
