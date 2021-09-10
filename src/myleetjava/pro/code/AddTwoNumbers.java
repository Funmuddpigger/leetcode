package myleetjava.pro.code;

import java.util.List;

public class AddTwoNumbers {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * 通过双指针,上下同时遍历链表, 大于>10,则设计进制位
     * 1. 通过上下比对,相加的值就是,当前node的val,
     * @param l1
     * @param l2
     * @return
     */
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode node = null;
         ListNode next = null;
         int count = 0;          //进制位
         while (l1 != null || l2 != null) {
             //初始化复制,空则赋0
             int val1 = l1 == null ? 0 : l1.val;
             int val2 = l2 == null ? 0 : l2.val;
             int val = val1 + val2 + count;
             /**
              * 判断node 就是 判断第一个节点是否存在,如果不存在
              * 则初始化一个新节点,如果存在,则新建next指针 , 接上去node
              * node 作为头结点,一直不变,next作为指针,一直往后移动
              */
             if (node == null) {
                 node = next = new ListNode(val % 10);
             } else {
                 next.next = new ListNode(val % 10);
                 next = next.next;
             }
             if(l1 != null){
                 l1 = l1.next;
             }
             if(l2 != null){
                 l2 = l2.next;
             }
             /**
              * 进制位进值计算
              * 1. 进位 1
              * 2. 不进位 0
              */
             count = val / 10;
         }
         /**
          * 最后判断是否还有最后一位需要进制位,要的话新增节点存放
          */
         if(count>0){
             next.next = new ListNode(count);
         }
         return node;
     }
}
