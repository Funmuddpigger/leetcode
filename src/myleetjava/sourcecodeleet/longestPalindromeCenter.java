package myleetjava.sourcecodeleet;

public class longestPalindromeCenter {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbbbbss"));
    }

    public static String longestPalindrome(String s){
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int i1 = expendsAroundCenter(s, i, i);
            int i2 = expendsAroundCenter(s, i, i + 1);//查看是否偶数个数的情况,例如:abbbbss  对应下标,i=2,len=4
            int len = Math.max(i1,i2);
            System.out.println(len);
            if(len>end-start){
                start=i-(len-1)/2;//也是因为while循环,右边比左边多出一个
                end=i+(len/2);
            }
        }
        System.out.println(end+":"+start);
        System.out.println(s.substring(start,end));
        return s.substring(start,end+1);
    }

    public static int expendsAroundCenter(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;//因为while循环里,left--和right++会多执行一次,所以要把不合规则的那一个长度去掉
    }
}
