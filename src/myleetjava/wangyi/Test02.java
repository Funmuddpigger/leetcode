package myleetjava.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(sc.nextInt());
        }

        System.out.println(numBack(len,list));
    }

    public static int numBack(int len, ArrayList<Integer> nums){
        int flagUp = 0,flagDown = 0;
        int upOrDown = 1;//1 up 2 down
        int up = 0,down = 0;
        for(int i =1;i<len;i++){
            if(i==1){
                if(nums.get(i)>nums.get(i-1)) {
                    up++;
                    upOrDown = 1;
                }
                if (nums.get(i)<nums.get(i-1)){
                    down++;
                    upOrDown =2;
                }
            }
            else if((flagDown==2||i<=3||upOrDown == 1)&&nums.get(i)>nums.get(i-1)){
                up++;
                upOrDown = 1;
                flagDown=0;
                flagUp++;
            }else if((flagUp==2||i<=3||upOrDown == 2 )&&nums.get(i)<nums.get(i-1)){
                down++;
                upOrDown = 2;
                flagUp=0;
                flagDown++;
            }
            else if(up>=2&&down>=2){
                    return i;
            }else{
                return 0;
            }

        }
        return len;
    }
}
