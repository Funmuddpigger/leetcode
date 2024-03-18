package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/3/18 10:48
 */
public class 组合总和Ⅳ_LCR104_combinationSum4 {

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }

    /**
     *  由于这道题只在乎求解的个数，而不在乎求具体的每个解，因此动态规划就可以完成。（如果具体的解，则需要回溯算法）
     *  新建数组dp[x],x是组合之和为x的组合数量
     *  转移方程dp[i] = dp[j] + dp[i-nums[j]](j属于nums里的每个数)
     *  动态规划的边界是 dp[0]=1\textit{dp}[0]=1dp[0]=1。只有当不选取任何元素时，元素之和才为 000，因此只有 111 种方案。
     */
    public static int combinationSum4(int[] nums, int target) {
        //初始化dp
        int[] dp = new int[target+1];
        dp[0] = 1;
        //遍历
        for(int i = 1;i<=target;i++){
            for (int j = 0;j<nums.length;j++){
                //如果当前i>=当前数，则相减
                if(i>=nums[j]){
                    dp[i] = dp[i] + dp[i-j];
                }
            }
        }
        return dp[target];
    }
}

