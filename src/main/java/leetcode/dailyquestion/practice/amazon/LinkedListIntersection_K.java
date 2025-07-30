package leetcode.dailyquestion.practice.amazon;

import lombok.ToString;

public class LinkedListIntersection_K {
    public static void main(String[] args) {

      /*  h1 -   10 --> 20 -->  40 --> 60 --> 80 --> 100
                /
                h2  -   30 -> 50  -> 55*/

        LinkedNode common = new LinkedNode(40);
        common.next = new LinkedNode(60);
        common.next.next = new LinkedNode(80);

        LinkedNode h1 = new LinkedNode(10);
        h1.next = new LinkedNode(20);
        h1.next.next = common;

        LinkedNode h2 = new LinkedNode(30);
        h2.next = new LinkedNode(50);
        h2.next.next = new LinkedNode(55);
        h2.next.next.next = common;

        System.out.println(findIntersection(h1,h2));


    }

    public static LinkedNode findIntersection(LinkedNode head1, LinkedNode head2) {

        LinkedNode p1 = head1;
        LinkedNode p2 = head2;

        while(p1!=p2){

            p1 = (p1.next!=null)? p1.next : head2;
            p2 = (p2.next!=null)? p2.next : head1;

        }

        return p1;
    }
}

@ToString
class LinkedNode {
    int data;
    LinkedNode next;

    LinkedNode(int val) {
        this.data = val;
    }
}