package myleetjava.sourcecodeleet;

import java.util.*;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countAndSay(n));
    }
    //1 11 21
    public static StringBuilder countAndSay(int n){
        StringBuilder strStr = new StringBuilder();
        int count = 0,temp = 0;
        if(n == 1 ){
            strStr.append(1);
        }
        while(n > 1){
            int len = strStr.length();
            for(int i=0;i<len;i++){
                temp=strStr.charAt(i);
                if(i>1&&i<len-1&&temp==strStr.charAt(i+1)){
                    count++;
                    strStr.deleteCharAt(i);
                }else if(i>1&&i<len-1&&temp!=strStr.charAt(i+1)){
                    count++;
                    strStr.deleteCharAt(i);
                    strStr.append(count);
                    strStr.append(temp);
                    count =0;
                }else{
                    strStr.deleteCharAt(i);
                    count ++;
                    strStr.append(count);
                    strStr.append(temp);
                }
            }
            n--;
        }
        return strStr;
    }
}
