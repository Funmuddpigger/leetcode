package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/8/9 11:02
 */
public class 跳跃游戏II_45_jump {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
    }

    /**
     * 贪心
     * 由于一定可达，遍历数组，寻找当前点位覆盖路径中的最远可达点位
     * 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
     */
    public static int jump(int[] nums) {
        int len = nums.length;
        int step = 0;
        if(len<=1) return step;
        int i = 0;
        while(i<len){
            //加上step，记录步数
            step++;
            //记录当前可达
            int num =i + nums[i];
            int max = 0;
            //判断是否到达顶端
            if(num>=len-1) break;
            //循环寻找能跳到最大的距离
            //距离 = 当前能跳到的点位 + 选择点位下次能挑到的点位
            // 10 9 8 7 6 5 4 3 2 1 1 0   ---> nums[0] 点位的距离 max = 0 +10 = 10，nums[1] max = 1 + 9 = 10
            //所以最远距离其实就是到达index = 10 的位置
            for(int j=i;j<=num;j++){
                if(max<=nums[j] + j){
                    i = j;
                    max = nums[j]+j;
                }
            }
        }
        return step;
    }

    /**
     * 官方题解，通过end记录当前能到达的最大长度，到达边界才对step +1
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
