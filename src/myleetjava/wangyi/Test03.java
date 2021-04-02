package myleetjava.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(sc.nextInt());
        }
        System.out.println(getSum(len,list));
    }

    public static int getSum(int len, ArrayList<Integer> arr){
        int temp = 0;
        for(int i =0;i<len ;i++){
            int j = i;
            int sum = 0;
            while(j<len){
                sum = sum + arr.get(j);
                if(sum%6==0){
                    temp = Math.max(temp, sum);
                }
                j++;
            }
            if(temp ==0 ){
                return 0;
            }
        }
        return temp;
    }
}
