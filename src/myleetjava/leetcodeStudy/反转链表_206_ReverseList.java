package myleetjava.leetcodeStudy;
//leetcode 反转链表
public class 反转链表_206_ReverseList {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println(head.val);
            return head;
        }
        ListNode rev = reverseList(head.next);
        System.out.println("head: " + head.val);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
