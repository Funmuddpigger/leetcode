package myleetjava.leetcodeStudy;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node3));
    }

     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode detectCycle(ListNode head) {
        /**
         * 双指针,从头出发,其中 a指针走2步,b指针走一步
         *  a指针为null,则无环
         *  若有环,则必会相遇
         *  其由于 等量关系 a = c + (n-1)(b+c)
         */
        ListNode fast = head;ListNode slow = head;

        while(fast !=  slow){
            //又终点,肯定不循环
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //相遇之后
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
