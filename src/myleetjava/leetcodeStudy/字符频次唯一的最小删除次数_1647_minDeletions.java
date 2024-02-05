package myleetjava.leetcodeStudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/1/17 15:52
 */
public class 字符频次唯一的最小删除次数_1647_minDeletions {


    /**
     * 先根据出现的次数排序
     * @param s
     * @return
     */
    public int minDeletions(String s) {
        int times = 0;
        //27个字母
        int[] counts = new int[26];
        int length = s.length();
        //遍历字符串
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            //计算出这个字母所在数组的idx，’a‘作为数组的首个位置
            counts[c - 'a']++;
        }
        //用一个set数组记录已存在的数字，且只记录 >0的
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0 && !set.add(counts[i])) {
                counts[i]--;
                times++;
            }
        }
        return times;
    }
}
