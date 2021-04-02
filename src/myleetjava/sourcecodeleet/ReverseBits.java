package myleetjava.sourcecodeleet;

import java.util.Scanner;
//leetcode 翻转2进制
public class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n){
        int rev =0;
        for(int i = 0;i<32&&n!=0;i++){
            rev= rev | (n & 1)<<( 31-i );
            n = n >>> 1;
        }
        return rev;
    }
}
