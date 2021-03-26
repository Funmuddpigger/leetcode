package myleetjava.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jump = sc.nextInt();
        System.out.println(getJump(n,jump));
    }

    public static int getJump(int n,int jump){
        ArrayList<Integer> jumpList = new ArrayList<>();
        ArrayList<Integer> jumpListRe = new ArrayList<>();
        int count =0,left,right=n-1,steps=0;
        while(count < n){
            jumpList.add(jump%10);
            jump = jump/10;
            count++;
        }
        for(int i = jumpList.size()-1;i>=0;i--){
            jumpListRe.add(jumpList.get(i));
        }
        System.out.println(Arrays.toString(new ArrayList[]{jumpListRe}));
        for(left =0;left<n;left++){
            while(right >left){
                if(jumpListRe.get(left)==jumpListRe.get(right)){
                    left=right;
                    //right=n-1;
                    break;
                }else{
                    right--;
                }

            }
            right= n-1;
            steps++;
        }
        return steps;
    }


}
