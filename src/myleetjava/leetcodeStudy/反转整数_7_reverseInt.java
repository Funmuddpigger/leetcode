package myleetjava.leetcodeStudy;

public class 反转整数_7_reverseInt {
    public static void main(String[] args) {
        reverse(1534236469);
    }

    public static int reverse(int x) {
        long res=0;
        while(x!=0){
            res = res*10 +  x%10;
            x = x/10;
        }
        System.out.println((int)res+"long: "+ res);
        return (int)res == res?(int)res : 0;
    }
}
