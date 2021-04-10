package myleetjava.ioinput;

import java.util.Scanner;

public class b2 {
    /**
     * 输入第一行包括一个数据组数t(1 <= t <= 100)
     * 接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
     */
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
            int times = sc.nextInt();
            while(times>0){
                System.out.println(sc.nextInt()+sc.nextInt());
                times--;
            }
        }

}
