package myleetjava.sourcecodeleet;

import java.util.Arrays;

//leetcode 605.种花问题
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int plants=0;
        int[] ans = new int[flowerbed.length + 2];
        if(n==0){
            return true;
        }
        //旧数组赋值给新数组
        for(int i =0 ;i<len;i++){
            ans[i+1] = flowerbed[i];
        }
        //判断左右是否0
        for (int i =1;i <= len;i++){
            if(ans[i]==0&&ans[i-1]==0&&ans[i+1]==0){
                plants++;
                //改变ans = 1，标记为种植状态
                ans[i]=1;
            }
        }
        System.out.println(Arrays.toString(ans));
        if(plants >= n ){
            return true;
        }
        return false;
    }
}
