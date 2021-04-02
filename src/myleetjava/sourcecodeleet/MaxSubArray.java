package myleetjava.sourcecodeleet;

import java.util.Scanner;
//leetcode
public class MaxSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[] = new int[10];
        for(int i = 0;i<10;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(maxSubArray1(nums));
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray1(int[] nums) {
        int len = nums.length;
        int temp = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int j = i;
            int sum = 0;
            while(j<len){
                sum = sum + nums[j];
                temp = Math.max(temp, sum);
                j++;
            }
        }
        return temp;
    }

    public static int maxSubArray2(int[] nums) {
        int pre = 0,maxAns = nums[0];
        for(int x : nums){    //遍历数组
            pre = Math.max(pre+x,x);  //比较pre(之前的和加上当前x的和,与当前x做对比,取大的,设为当前pre的值作为和)
            maxAns = Math.max(maxAns,pre);  //与上一步设好的pre的和,来对比当前所有结果中,最大的和值
        }
        return maxAns;
    }
}
