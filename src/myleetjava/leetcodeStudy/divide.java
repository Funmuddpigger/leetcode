package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.List;

public class divide {

    public static void main(String[] args){
        System.out.println(divide(2147483647,2));
    }
    public static int divide(int dividend, int divisor) {
        //边界情况
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用类二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        //通过左移逐渐扩大divisor,接近dividend
        List<Integer> list = new ArrayList<>();
        list.add(divisor);
        int t = 0;
        //循环,当被除数增大到大于 除数 - 被除数
        while(list.get(t) >= dividend - list.get(t)){
            list.add(list.get(t)<<1);
            t++;
        }
        //逆序输出
        int ans = 0;
        for(int i = list.size() - 1;i>=0;i--){
            if(list.get(i) >= dividend){
                ans += 1 << i;
                dividend = list.get(i);
            }
        }
        return rev?-ans : ans;
    }
}
