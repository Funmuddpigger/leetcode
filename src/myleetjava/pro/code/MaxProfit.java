package myleetjava.pro.code;

import java.util.Arrays;
import java.util.List;

public class MaxProfit {
    public static void main(String[] args) {

    }

    /**
     * 1. 设置一个二维数组,dp[i][j]----对应第i天买入,第j天卖出
     * 2. 设第dp[i][j+N],则可以得出,dp[i][j+N]=dp[i][j]+(dp[j][N]=dp[j][j+1]+......)
     * 3. dp[i][j]=dp[i][N]+dp[N][j]
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //半暴力法,效率低下
        int len = prices.length - 1;
        int dp[][] =  new int[len][ len];
        int max = 0;
        //初始化最初的两两关系(每两天算一次)
        for(int i = 0; i<len; i++){
            dp[i][i+1]=prices[i+1]-prices[i];
            if(dp[i][i+1]>max){
                max = dp[i][i+1];
            }
        }
        for(int i=0;i<len;i++){
            for(int j=i+2;j<=len;j++){
                dp[i][j]=dp[i][j-1]+dp[j-1][j];
                if(dp[i][j]>max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    //条件 1：你不能在买入股票前卖出股票；
    //条件 2：最多只允许完成一笔交易
    //dp[i][j]：下标为 i 这一天结束的时候，手上持股状态为 j 时，我们持有的现金数。
    //j = 0，表示当前不持股；
    //j = 1，表示当前持股。
    //这个状态具有前缀性质，下标为 i 的这一天的计算结果包含了区间 [0, i] 所有的信息，因此最后输出 dp[len - 1][0]。

    //dp[i][0]：规定了今天不持股，有以下两种情况：
    //昨天不持股，今天什么都不做；
    //昨天持股，今天卖出股票（现金数增加）

    //dp[i][1]：规定了今天持股，有以下两种情况：
    //昨天持股，今天什么都不做（现金数与昨天一样）；
    //昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
    public static int maxProfitDp(int[] prices) {
        int len = prices.length;
        if(len<2){
            return 0;
        }
        int dp[][]=new int[len][2];
        dp[0][1]=-prices[0];
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]); //(持股,今天卖出 , 不干事)
            dp[i][1]=Math.max(-prices[i],dp[i-1][1]);
        }
        //最后2种情况 1. 卖出了股票 2. 未购买股票  两种都是不存在持有股票的
        //len-1 是因为无论如何都会把持有利润最大的值带到最后一天
        return dp[len-1][0];
    }
}
