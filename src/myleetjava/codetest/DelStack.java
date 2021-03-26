package myleetjava.codetest;

import java.util.Arrays;
import java.util.Stack;

public class DelStack {
    public static void main(String[] args) {
        System.out.println(delStakcArray(new int[]{9,9,8,4,5,6,8,8,9,4,2,5,4}));
    }

    public static int delStakcArray(int[] arr){
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(arr);
        int len = arr.length;
        for(int i=0;i<len;i++){
            if(stack.empty()){
                stack.push(arr[i]);
                continue;
            }

            if(stack.peek() == arr[i]){
                continue;
            }else{
                stack.push(arr[i]);

            }
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
        return 0;
    }
}
