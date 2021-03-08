package myleetjava.sourcecodeleet;

import java.util.ArrayList;

public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,3});
    }
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len-2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while(left<right){
            swap(nums,nums[left],nums[right]);
            left--;
            right++;
        }
    }
}
