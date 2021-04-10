package myleetjava.ioinput;

import java.util.Scanner;

/**
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
 */
public class a1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(sc.nextInt()+sc.nextInt());
        }
    }
}
