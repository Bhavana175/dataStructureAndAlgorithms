package com.workspace.learning.interviews.goldS.practice.two;

public class RemoveLoopInLinkedList {
    //https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1?page=1&company=Goldman%20Sachs&sortBy=submissions

    public static void main(String[] args) {

        NodeLL n1 = new NodeLL(1);
        NodeLL n2 = new NodeLL(2);
        NodeLL n3 = new NodeLL(3);
        NodeLL n4 = new NodeLL(4);
        NodeLL n5 = new NodeLL(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        // 7 58 36 34 16
        //display(n1);
        removeLoop(n1);
        display(n1);

    }

    public static void removeLoop(NodeLL head) {
        if (head != null) {
            boolean loopFound = false;
            NodeLL fast = head;
            NodeLL slow = head;
            while (slow.next != null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (slow == fast) {
                    loopFound = true;
                    break;
                }
            }
            if (loopFound) {
                // loop and found
                slow = head;
                NodeLL prev = fast;
                while (slow != fast) {
                    slow = slow.next;
                    prev = fast;
                    fast = fast.next;
                }
                prev.next = null;
            }
        }
    }

    public static void display(NodeLL head) {
        NodeLL aux = head;
        while (aux != null) {
            System.out.print(aux.data + " -> ");
            aux = aux.next;
        }
        System.out.println("NULL");
    }

}
