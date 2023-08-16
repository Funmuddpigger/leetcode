package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/8/7 14:59
 */
public class 跳跃游戏_55_canJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1,2,3}));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        //设立从下标0开始的指针
        int pointer = 0;
        int longest = 0;
        /**
         * 贪心法，直接去遍历数组，维护一个当前最远可达位置
         *  1. 如果遍历完毕，最远可达距离大于等于数组长度，则返回true，否则为false
         */
        while(pointer<len){
            //从下标0开始进行遍历
            int num = nums[pointer];
            //如果当前下标的数小于最远距离，则加上他的最大跳跃距离
            if(pointer<=longest){
                longest = Math.max(longest,pointer+num);
                if(longest>=len-1){
                    return true;
                }
            }
            pointer++;
        }

        return false;
    }

}
