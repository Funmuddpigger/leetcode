package myleetjava.leetcodeStudy;

//leetcode 19. 删除链表的倒数第 N 个结点
public class 删除链表的倒数第N个结点_19_removeNthFromEnd {


      //Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     *通过形参的方式,传入length方法获取长度而不改变head,然后找到 被删除节点的 前驱节点--pre ,然后删除,让前驱的next指向被删除节点的
     * 后继节点 end
     * @param head
     * @param n
     * @return
     */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int del=length(head)-n;
            ListNode pre = head;
            if(del==0){
                return head.next;
            }
            for(int i=1;i<del;i++){
                pre = pre.next;
            }
            pre.next=pre.next.next;
            return head;
        }

        private int length(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }

}
