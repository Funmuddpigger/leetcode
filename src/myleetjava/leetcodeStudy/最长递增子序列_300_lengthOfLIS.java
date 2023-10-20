package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/10/20 14:40
 */
public class 最长递增子序列_300_lengthOfLIS {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
    /**
     * 建立一个dp数组，记录每个位置的最长子序列
     * 当nums[x] > nums[i-x]
     *  通过 dp[i] = dp[i-x] + 1
     *  其余情况则直接跳过，
     *  最后取max
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        //第0个字母肯定是子序列长度为1的
        int res = 1;
        dp[0] = 1;
        //遍历dp
        for (int i = 1; i < len; i++) {
            int max = 1;
           for(int j = i-1;j>=0;j--){
               if(nums[i] > nums[j]) max = Math.max(dp[j] + 1,max);
           }
           dp[i] = max;
           res = Math.max(max,res);
        }
        return res;
    }

}
