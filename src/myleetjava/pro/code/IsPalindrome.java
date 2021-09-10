package myleetjava.pro.code;

import java.util.ArrayList;

//leetcode 回文链表
public class IsPalindrome {
    public static void main(String[] args) {
    }
}

//Definition for singly-linked list.
class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reversList(slow);
        while(slow !=null){
            if(slow.val != head.val )
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    //6 3  head  0 1 2 3   head.next 1 2 3 4
    public ListNode reversList(ListNode slow){
        ListNode real = slow;
        // 1->2->3->4  1. 2->1->3->4 2. 3->2->1->4 3. 4->3->2->1
        // head -> 1
        while(slow.next!=null){
            ListNode temp = slow.next;
            slow.next = slow.next.next;
            temp.next = real;
            real = temp;
        }
        return real;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}


