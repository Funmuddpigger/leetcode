package myleetjava.sourcecodeleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(getthreeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> getthreeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        if(len<3){
            return ans;
        }
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int first=0;first<len;first++){   //枚举第一个数
            if (first >0 && nums[first] == nums[first-1]){  //排序后,可以去重,相同的数字都在前后位置上
                continue;
            }
            int left = first+1,right = len - 1;
            while(left<right){
                if(left>first+1 && nums[left]==nums[left-1]){   //左指针去重
                    left++;
                    continue;
                }
                if(nums[first]+nums[left]+nums[right]==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                }
                else if(nums[first]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}
