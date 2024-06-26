package com.workspace.learning.interviews.epampractice;

import java.util.Arrays;

public class MaxSumTwinNodeLL {

    //https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(15);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        // 1,2,3,4,5,6
        // 5,6,1,2,3,4

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(pairSum(n1));
        // i, n-1-i is a pair where n is even
    }

//all time complexity of the code is O(n) and the space complexity is O(n).

    public static int pairSum(ListNode head) {

        if (head == null) {
            return 0;
        }

        int n = 1;
        ListNode aux = head;
        while (aux.next != null) {
            n++;
            aux = aux.next;
        }

        if (n % 2 != 0) {
            return 0;
        }


        int[] sum = new int[n / 2];
        aux = head;
        int max =0;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                sum[i] = aux.data;
                if(max<sum[i]){
                    max= sum[i];
                }
            } else {
                sum[n - 1 - i] = sum[n - 1 - i] + aux.data;
                if(max<sum[n - 1 - i]){
                    max= sum[n - 1 - i];
                }
            }

            aux = aux.next;
        }

        return max;
    }
}
