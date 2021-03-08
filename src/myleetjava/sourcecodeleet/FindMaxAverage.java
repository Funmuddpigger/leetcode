package myleetjava.sourcecodeleet;

import java.util.*;

//leetcode 643. 子数组最大平均数 I
public class FindMaxAverage {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1},1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        List<Double> res = new ArrayList<>();
        int len = nums.length;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum=sum+nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < len; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
