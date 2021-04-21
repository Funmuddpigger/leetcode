package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode 242. 有效的字母异位词
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        LinkedList<Character> collect = new LinkedList<>();
        int lens = s.length();
        int lent = t.length();
        if(lens != lent){
            return false;
        }
        for(int i=0;i<lens;i++){
            collect.add(s.charAt(i));
        }
        for(int j=0;j<lent;j++){
            boolean b = collect.removeFirstOccurrence(t.charAt(j));
            if(!b){
                return false;
            }
        }
        if(collect.size()>0){
            return false;
        }
        return true;
    }
    //两个方法类似的思路,一个数组负责添加,一个数组负责减去,
    //而算法负责构建了一个26位的字母表, 因为int数组会编程ascii码进行运算
    //S字符串负责在对应的数组中 +1 ,而 T字符串负责 -1 ,最后如果 0 ,证明都抵消了.
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}
