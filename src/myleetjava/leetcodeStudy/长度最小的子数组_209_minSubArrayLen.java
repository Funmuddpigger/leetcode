package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/11/9 10:12
 */
public class 长度最小的子数组_209_minSubArrayLen {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    /**
     * 滑动窗口，通过前后指针，前指针先走，每次判断两指针内的所有数相加是否大于target，记录长度
     *  1. 如果大于target，则后指针往前移动，重新计算是否大于target，是的话记录最小长度
     *  2. 如果上述步骤未>=target，则前指针继续往前移动，重复一开始的步骤
     *  3. 直至遍历结束，返回最小长度
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0,len = nums.length,sum = 0,min = len+1;
        while(left<len){
            sum = sum + nums[left];
            //目标值范围内，则右指针前移，缩小数组长度
            while (sum >= target&&right<=left){
                //计算最小数组长度
                min = Math.min(min,left-right+1);
                right++;
                sum = sum - nums[right-1];
            }
            left++;
        }
        return min == len+1? 0 : min;
    }
}
