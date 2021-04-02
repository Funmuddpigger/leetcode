package myleetjava.wangyi;

import jdk.nashorn.internal.ir.BinaryNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(sc.nextInt());
        }

        System.out.println();
    }

    public static void getShort(ArrayList<Integer> arr,int x){
        //动态规划 每次可以选择走左子树或者右子树,相等 x 则跳出到下一个路径
        int size = arr.size();
        for(int i=0;i<size;i++){
            int left = i;
            int sum = 0;
            while(2*left<size){
                sum = sum + arr.get(2*left);
            }
        }

    }

}
