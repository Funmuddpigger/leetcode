package myleetjava.sourcecodeleet;

import java.util.ArrayList;
import java.util.List;

public class halvesAreAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }

    public static boolean halvesAreAlike(String s) {
        char[] chars = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        int count1= 0,count2 =0;
        int len = s.length();
        String str1 = s.substring(0, len / 2);
        String str2 = s.substring(len/2, len);
        System.out.println(s.substring(0,len/2));
        System.out.println(s.substring(len/2,len));
        for (char ch : chars){
            for(char str : str1.toCharArray()){
                if(ch==str) count1++;
            }
            for(char str : str2.toCharArray()){
                if(ch==str) count2++;
            }
        }
        System.out.println(count1+":"+count2);
        if(count1==count2){
            return true;
        }
        return false;
    }

}
