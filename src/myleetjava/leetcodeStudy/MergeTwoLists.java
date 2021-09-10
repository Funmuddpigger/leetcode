package myleetjava.leetcodeStudy;

public class MergeTwoLists {

//     * Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null){
                System.out.println("l2.head: "+ l2.val);
                return l2;
            }else if(l2==null){
                System.out.println("l1.head: "+ l1.val);
                return l1;
            }else if(l1.val>=l2.val){
                l2.next = mergeTwoLists(l1,l2.next);   //把链表连接上,把该值赋值给下一个递归的结果,可以让两个链表相互连接起来
                System.out.println("l2: "+ l2.val);
                return l2;
            }else{
                l1.next = mergeTwoLists(l1.next,l2);
                System.out.println("l1: "+ l1.val);
                return l1;
            }
        }

}
