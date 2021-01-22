package myleetjava.sourcecodeleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //先找出 "较大分组" 然后在向前向后遍历,时间和空间复杂度较高,但是可以省去一下不必要的遍历
        for(int i=1;i<s.length();i++){
            char current = s.charAt(i);
            //构成较大分组
            if(i+1<s.length()&&s.charAt(i-1)==current&&current==s.charAt(i+1)){
                //左指针向前找
                int left = 1;
                int right = 1;
                while(i-left>=0&&s.charAt(i-left)==s.charAt(i)){
                    left++;
                }
                //右指针向右找
                while(i+right<s.length()&&s.charAt(i+right)==s.charAt(i)){
                    right++;
                }
                ans.add(Arrays.asList(i-left+1,i+right-1));
                i = i+right;
            }
        }
        return ans;
    }
    //官方题解,依次遍历
    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
