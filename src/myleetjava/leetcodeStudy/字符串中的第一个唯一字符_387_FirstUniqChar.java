package myleetjava.leetcodeStudy;

import java.util.LinkedHashMap;
import java.util.Map;
//leetcode 字符串中的第一个唯一字符
public class 字符串中的第一个唯一字符_387_FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("dddccdbba"));
    }

    public static int firstUniqChar(String s) {
        int len = s.length();
        Map<Character,Integer> res = new LinkedHashMap<>();
        for(int i=0;i<len;i++){
            res.put(s.charAt(i),res.getOrDefault(s.charAt(i),0)+1);
        }
        for(int j=0;j<len;j++){
            //.out.println(res.get(1));
            if(res.get(s.charAt(j))==1){
                return j;
            }
        }
        return -1;
    }
}
