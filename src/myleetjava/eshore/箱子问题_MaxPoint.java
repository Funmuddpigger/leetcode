package myleetjava.eshore;

import java.util.ArrayList;
import java.util.List;
public class 箱子问题_MaxPoint {
    public static List<Integer> getMaxScore(int X, int[] arrs) {
        // 初始化 dp 数组
        int[][] dp = new int[X+1][X+2];
        // 动态规划求解最大积分数
        for (int i = 1; i <= X; i++) {
            for (int j = 1; j <= X; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + arrs[i-1] * arrs[i] * arrs[i+1], dp[i-1][j]);
            }
        }
        // 回溯找出箱子的顺序
        List<Integer> sequence = new ArrayList<>();
        int maxScore = 0;
        int idx = 0;
        for (int j = 1; j <= X; j++) {
            if (dp[X][j] > maxScore) {
                maxScore = dp[X][j]; idx = j;
            }
        }
        for (int i = X; i > 0; i--) {
            sequence.add(idx-1);
            if (dp[i][idx] == dp[i-1][idx-1] + arrs[i-1] * arrs[i] * arrs[i+1]) {
                idx--;
            }
        }
        // 反转顺序
        List<Integer> reversedSequence = new ArrayList<>();
        for (int i = sequence.size() - 1; i >= 0; i--) {
            reversedSequence.add(sequence.get(i));
        }
        return reversedSequence;
    }
    public static void main(String[] args) {
        int X = 5; int[] arrs = {2, 1, 6, 3};
        List<Integer> result = getMaxScore(X, arrs);
        System.out.println("Max Score: " + result.size());
        System.out.println("Sequence: " + result);
    }
}