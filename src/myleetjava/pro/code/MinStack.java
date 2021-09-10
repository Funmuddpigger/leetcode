package myleetjava.pro.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    private int min;
    private Stack<Integer> stack = new Stack<>();
    /**
     * initialize your data structure here.
     */
    /**
     * 通过 res = val - min ---该min是上一个最小值  的操作,可以把上一个最小值的值保存起来
     * 当栈里最小值出栈, 只需要把 (上一个)min = val - res即可
     */
    public MinStack() {

    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
        }else{
            //计算差值
            int res = val - min;
            //判断该val与min的差值是否 <0,是的话成为新的最小值
            min = res < 0 ? res : min;
            //最小值入栈
            stack.push(val);
        }
    }

    public void pop() {
        Integer res = stack.peek();
        //出栈前,先看栈顶的值是否为最小值,如栈顶res<0则是当前的最小值(栈里可能还有<0的res,但不是当前的min),则是最小值
        //则更新min
        //  min - res <==> val- res = min(也就是push进来的上一次的min)
        min = res < 0 ? (min-res) : min;

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

