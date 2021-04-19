package myleetjava.tx;

import java.util.ArrayList;
import java.util.List;

public class test01 {

    public class ListNode {
        public ListNode(){

        }
        int val;
        ListNode next = null;
    }
    public ListNode solve (ListNode S) {
        // write code here
        //记录长度,循环整个链表,找出最小元素放到第一个;
        int small = S.val,big = S.val,smallCount = 0;
        List<Integer> res = new ArrayList<>();
        while(S.next!=null){
            res.add(S.val);
            if(S.next.val<small){
                small = S.next.val;
            }else if(S.next.val>=big){
                big = S.next.val;
            }
            S = S.next;
        }
        //链表循环,     把最小的放到第一个,最大的往后靠,并且如果有相同的要比较相对大小,
        int len = res.size();
        for(int i=0;i<len;i++){
            //while(res.get(i)>)
        }

        return S;
    }
}
