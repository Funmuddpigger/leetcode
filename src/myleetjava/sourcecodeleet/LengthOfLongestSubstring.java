package myleetjava.sourcecodeleet;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkewg";
        Set<Character> coc = new HashSet<>();
        int rk = -1;
        int ans = 0;
        for(int i =0;i <s.length();i++ ){
            if(i!=0){
                //i = rk+1;
                coc.remove(s.charAt(i - 1));
                System.out.println("i:"+s.charAt(i - 1));
            }
            while(rk+1<s.length()&&!coc.contains(s.charAt(rk+1))){
                coc.add(s.charAt(rk+1));
                rk++;
                System.out.println("rk:"+rk);
            }
            ans = Math.max(ans,rk-i+1);
            System.out.println("ans:"+ans);
        }
        System.out.println(ans);
    }
}
