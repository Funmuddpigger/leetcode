package myleetjava.pro.code;

public class Rob {
    public static void main(String[] args) {

    }

    /**
     * 约束条件:  1. 相邻的房屋只能被窃取其中一间
     *          2. 金额最大
     * 设立状态: 1. 窃取第k间房屋的话,那么第k-1间房屋就不能被抢,金额贼为k-2间最高金额总和 + k
     *         2. 不窃取第k间放,则金额为k-1的最高总和
     * dp equation: dp[k][] ,第0-i间房子偷了后的最大值
     *              dp[][0/1],1为偷了,0没偷
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int dp[][]=new int[len][];
        dp[1][0]=0;
        dp[1][1]=nums[0];
        for(int k =1;k<len;k++){
            dp[k][0]=Math.max(dp[k-1][1],dp[k-1][0]);
            dp[k][1]=dp[k-1][0]+nums[k];
        }
        return Math.max(dp[len][0],dp[len][1]);
    }

    /**
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        int dp[]=new int[len];
        dp[0]=nums[0];
        for(int k =2;k<len;k++){
           dp[k]=Math.max(dp[k-1],dp[k-2]+nums[k]);
        }
        return dp[len-1];
    }
}
