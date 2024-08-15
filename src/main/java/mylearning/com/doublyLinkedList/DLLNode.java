package mylearning.com.doublyLinkedList;

public class DLLNode {
    int val;
    DLLNode prev;
    DLLNode next;

    DLLNode(int val){
        this.val = val;
    }

    DLLNode(int val, DLLNode prev, DLLNode next ){
        this.val= val;
        this.prev = prev;
        this.next = next;
    }

    DLLNode(int val, DLLNode next){
        this.val= val;
        this.next= next;
    }
}
