package myleetjava.pro.code;

public class SwapPairs {
    // Definition for singly-linked list.
        static class  ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode four =  new ListNode(4,null);
        ListNode three =  new ListNode(3,four);
        ListNode two =  new ListNode(2,three);
        ListNode one =  new ListNode(1,two);
        System.out.println(swapPairs(one));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        /**
         头节点
         */
        res.next = head;
        /**
         初始化三个节点 p--扫描节点,pre--前节点,last--后一个节点
         */
        ListNode pre = res,last = null ,p = null;

        while(pre!=null&&pre.next.next!=null){
            last = pre.next.next;
            p = pre.next;
            /**
             0 1 2 3 4, 0是头节点
             开始交换,pre = 0 连接到last = 2, p = 1连接到 last.next = 3 , last = 2 连接到 p = 1
             pre 移动到  2 的位置 交换后 就是 0 2 1 3 4 也就是节点 1;
             */
            pre.next = last;
            p.next = last.next;
            last.next = p;
            pre = p;
        }
        return res.next;
    }

}




