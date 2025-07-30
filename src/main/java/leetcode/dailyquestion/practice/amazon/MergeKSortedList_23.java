package leetcode.dailyquestion.practice.amazon;

import java.util.PriorityQueue;

public class MergeKSortedList_23 {
    public static void main(String[] args) {

    }

    // O(n log(k)) space: O(k) priority queue holding k elements
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode aux = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            aux.next = new ListNode(temp.val);
            aux = aux.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }

        return head.next;
    }

    public static class ListNode {
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
}
