package myleetjava.leetcodeStudy;

/**
 * TODO
 *
 * @author ：LI.JUNJIE
 * @date ：2024/5/28 16:11
 */
public class 接雨水_42_trap {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }


    /**
     * 通过双指针，利用leftMax和rightMax记录两个桶边的最高度，由于是按最小的桶边决定水量，因此只要
     * 处于i位置能装的水，就从最短边的搞度减去当前高度，即Math.Min(leftMax,rightMax) - height = water
     * 1. 开始先从左边走起，当height[left] < height[right]的时候，也就是leftMax < rightMax
     *    则有water = leftMax - height[left]; left++ 循环1
     * 2. 当height[left] >= height[right]的时候，也就是leftMax >= rightMax
     *    则有water = rightMax - height[right]; right --
     * 3. 直到两指针相遇，结束循环
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int water = 0;
        int left =0,right = height.length -1;
        int leftMax = 0, rightMax = 0;
        // 未相遇前，继续计算
        while(left<right){
            // 计算左右区域的最大桶边
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            // 找最低桶边
            if(height[left]<height[right]){
                water += leftMax - height[left];
                left++;
            }else{
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

}
