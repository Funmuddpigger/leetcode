package myleetjava.leetcodeStudy;

import java.util.Arrays;
import java.util.Scanner;

//leetcode 189.旋转数组
public class 旋转数组_189_Rotate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate2(new int[]{1,2,3,4,5,6,7},3)));
        Scanner sc = new Scanner(System.in);
    }

    //mod运算,算出新旧位置,i+k/mod是为防止 > len的情况
    public static int[] rotate(int nums[],int k){
        int len = nums.length;
        int[] res = new int[len];
        int n = 0,temp = k;
        while(k>0){
            if(k>len){
                res[n] = nums[len-k];
                k--;
                n++;
            }
            res[n] = nums[len-k];
            k--;
            n++;
        }
        for(int i = temp; i<len;i++){
            res[i] = nums[i-temp];
        }
        for(int i = 0;i<len;i++){
            nums[i] = res[i];
        }
        return nums;
    }

    public static int[] rotate2(int nums[],int k){
        int len = nums.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = nums[i];
        }
        for(int i=0;i<len;i++){
            nums[(i+k)%len] = res[i];
        }
        return nums;
    }
}
