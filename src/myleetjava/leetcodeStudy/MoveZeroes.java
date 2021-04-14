package myleetjava.leetcodeStudy;

//leetcode 移动零
public class MoveZeroes {
    /**
     * 双指针,slow记录0的个数,如果遇到0则加一,然后fast继续后移动
     * fast-slow------因为每次交换后 0 总处于未交换的数组的最前面,
     * 所以fast - slow = 所有0中最前面0的位置
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int len = nums.length;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] == 0) {
                slow++;
            } else if (slow != 0) {
                nums[fast - slow] = nums[fast];
                nums[fast] = 0;
            }

        }

    }

    /**
     * 双指针,非0则往前挪,当没有0是,则是和自己进行交换,所以值不会发生改变
     * 每次遇到非0,怎 slow指针往后移,直到遇到0,slow指针指向0,fast指针指向非0
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0;
        int len = nums.length;
        for (int fast = 0; fast < len; fast++) {
            if (slow != -1 && nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;

                slow++;
            }
        }
    }
}
