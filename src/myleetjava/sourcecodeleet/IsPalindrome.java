package myleetjava.sourcecodeleet;

//leetcode 9. Palindrome Number 回文数
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x<0)  return false;
        int i = 0;
        int res = x;
        while(x>0){
            i = i*10 + x%10;
            x=x/10;
        }
        if(i==res) return true;
        return false;
    }
}
