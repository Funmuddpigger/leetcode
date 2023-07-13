package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2022/10/31 9:33
 */
public class PartitionDisjoint {

    public static void main(String[] args) {

    }

    public int partitionDisjoint(int[] nums) {
        /**
         * 遍历一次，每次记录当先 0 ~ i 的最大值以及下标 maxLeft ，maxIdx
         * 若后续没有比此maxLeft最大值小的数，则证明分割从maxIdx后一位隔开
         * 若有比maxLeft小的数，则继续更新maxIdx
         */
        int len = nums.length;
        int maxLeft = nums[0],maxIdx = 0;
        for(int i=1;i<len;i++){
            //判断maxLeft 与 当前值的大小
            int max = Math.max(maxLeft, nums[i]);
            //如果比maxLeft更大，则不用处理，继续延续，若小，则更新idx
            if(max<=maxLeft){
                i = maxIdx;
            }else{
                maxLeft = max;
            }
        }
        return maxIdx + 1;
    }

}
