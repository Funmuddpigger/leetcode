package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/9/26 10:09
 */
public class 零钱兑换_322_CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1},10000));
    }

    /**
     * 利用dp，新建一个dp[amount+1]的数组，记录从dp[0]到dp
     * dp[i]表示组成i的总价需要最少多少枚硬币
     * 得出方程：
     *     dp[i] = min(dp[i - coin[x]] + 1)
     *  其中 dp[i - coin[x]]：
     *      coin[x] 代表可选金币的遍历
     *      dp[i-coin[x]]代表 总额 - 当前遍历金币 的最优解
     *      +1 则是需要把当前遍历的那枚金币也算上
     */
    public static int coinChange(int[] coins, int amount) {
        //新建amount数组
        int[] dp = new int[amount + 1];
        //当dp为0的时候，硬币数一定为0
        dp[0] = 0;
        //从amount =1，填充dp数组
        for(int i = 1;i <= amount;i++){
            int min = 999999;
            //遍历硬币， 开始
            for (int j = 0;j<coins.length;j++){
                //计算剩余restAmount
                int restAmount = i - coins[j];
                //如果剩余数值超过已经遍历的dp[i]，则直接进入下一个dp 循环
                if(restAmount<0||restAmount>i||dp[restAmount]==-1){
                    continue;
                }
                min = Math.min(dp[restAmount] + 1, min);
            }
            dp[i] = min == 999999 ? -1 : min;
        }
        return dp[amount];
    }

}
