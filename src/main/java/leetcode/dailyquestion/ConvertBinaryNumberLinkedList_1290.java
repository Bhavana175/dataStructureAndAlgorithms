package leetcode.dailyquestion;

public class ConvertBinaryNumberLinkedList_1290 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(1);

        l1.next = l2;
        l2.next =l3;
        System.out.println(getDecimalValue(l1));
    }
    public static int getDecimalValue(ListNode head) {
        ListNode curr = head;
        if(curr == null ) return 0;
        StringBuilder sb  = new StringBuilder();

        while (curr!=null){
            sb = sb.append(curr.val);
            curr = curr.next;
        }

        return  Integer.parseInt(sb.toString(), 2);


    }
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
