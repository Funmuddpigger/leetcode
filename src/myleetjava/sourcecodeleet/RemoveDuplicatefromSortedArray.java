package myleetjava.sourcecodeleet;

import java.util.Stack;

public class RemoveDuplicatefromSortedArray {

        public static void main(String[] args) {
            int[] nums = new int[]{1, 1, 2};
            Stack stack=new Stack();
            int top = 0;
            stack.push(nums[0]);
            top++;
            for(int i = 1 ; i <nums.length;i++){
                if(Integer.parseInt(stack.peek().toString())!=nums[i]){
                    stack.push(nums[i]);
                    top++;
                }
            }
            System.out.println(top);
        }

}


