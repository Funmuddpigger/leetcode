package myleetjava.threeseven;

import java.util.Scanner;

public class BinaryAboutOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        int count = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            int i1 = (n & 1);
            n >>>= 1;
            if (i1 == 1) {
                System.out.println(i1);
                count++;
            }
        }
        return count;
    }
}


