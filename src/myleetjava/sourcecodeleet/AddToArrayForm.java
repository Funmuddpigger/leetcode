package myleetjava.sourcecodeleet;

import java.util.ArrayList;
import java.util.List;

//leetcode  989. 数组形式的整数加法
public class AddToArrayForm {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{0},23));
    }
    public  static List<Integer> addToArrayForm(int[] A, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = A.length,sum = 0, carry = 0;

        for(int i = len-1 ; i >= 0 || K > 0;i--,K=K/10){
                if(i>=0){
                    sum  = A[i] + K % 10+carry;
                }else{
                    sum = K%10 + carry;
                }
                res.add(0,sum%10);
                carry = sum/10;
        }
        if (carry != 0) res.add(0, carry);
        return res;
    }

    //官方题解
    /**
     * class Solution {
     *     public List<Integer> addToArrayForm(int[] A, int K) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         int n = A.length;
     *         for (int i = n - 1; i >= 0; --i) {
     *             int sum = A[i] + K % 10;
     *             K /= 10;
     *             if (sum >= 10) {
     *                 K++;
     *                 sum -= 10;
     *             }
     *             res.add(sum);
     *         }
     *         for (; K > 0; K /= 10) {
     *             res.add(K % 10);
     *         }
     *         Collections.reverse(res);
     *         return res;
     *     }
     * }
     *
     */
}
