package myleetjava.sourcecodeleet;

import java.util.Stack;

public class RemoveDuplicatefromSortedArray2 {

        public static void main(String[] args) {
            int[] num2s = new int[]{1, 1, 2, 2, 3, 3, 4, 5};
            int i = 0;
            if(num2s.length==0){
                System.out.println(0);
            }
            for(int j =1;j<num2s.length;j++){
                if(num2s[i]!=num2s[j]){
                    i++;
                    num2s[i]=num2s[j];
                }
            }
            System.out.println(i+1);
        }

}


