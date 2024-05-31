package myleetjava.leetcodeStudy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/4/15 16:41
 */
public class 同构字符串_205_isIsomorphic {

    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        return isIsomorphicPair(s).equals(isIsomorphicPair(t));
    }


    /**
     * 维护一个tx数，挡tx
     * 利用ascill码，映射到数组上，
     *
     * @param s
     * @param t
     * @return
     */
    public StringBuilder isIsomorphicPair(String s) {
        StringBuilder s1 = new StringBuilder();
        //映射map
        int[] map = new int[128];
        //转换成数字
        int tx = 1;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //判断是否第一次出现
            if(map[c]==0){
                map[c] = tx;
                tx++;
            }
            s1.append(map[c]);
        }
        return s1;
    }
}
