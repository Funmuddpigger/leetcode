package myleetjava.pro.code;

public class IsMatch {
    public static void main(String[] args) {

    }
    /**
     *  两个指针, 一个 i 指向 s,一个 j 指向 p
     *  动态转移方程:
     *  第一种情况:
     *      if i , j 都指向的是英语字母 ,且  i , j 个字符是否相同 ,则取决于 第 0->(i-1) ,0->(j-1)的字符是否相同
     *      dp[i][j] = dp[i-1] + dp[j-1]  dp[i]=dp[j];
     *                  false             dp[i]!=dp[j];
     *  第二种情况:
     *      if j指向了 * ,则需要和 * 的前一个字符绑定 然后这里又出现两个情况
     *
     *      1. 如果 字母 + * 的组合 和 i 指向的字符匹配成功, 则 i 前移 -> i-1
     *      2. 如果 字母 + * 的组合 和 i 指向匹配不成功( * 可以匹配0个) , 则 这个组合所占的两个位置都去除,
     *         前移2个位置 --> i-2
     *
     *         dp[i-1][j] || dp[i][j-2]   s[i]=p[j-1]     //一样,则前移,,前移到不一样的时候,则丢弃组合
     *         dp[i][j-2]                 s[i]!=p[j-1]    //不一样,丢弃组合
     * 第三种情况:
     *      在任意情况下，只要 p[j]p[j] 是 .，那么 p[j]p[j] 一定成功匹配 字符串 中的任意一个小写字母。
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int i=0,j=1;
        boolean[][] dp = new boolean[sLen+1][pLen+1];

        //开始遍历
        while(i==0){
            while(j==1) {
                //判断是那种符号,* 则执行情况2
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 2];  //因为* ,j 和 j-1 两的匹配状态是一致的
                    if (matches(s, p, i, j - 1)) {

                    }
                }

            }
        }
        return dp[sLen][pLen];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        //判断
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
