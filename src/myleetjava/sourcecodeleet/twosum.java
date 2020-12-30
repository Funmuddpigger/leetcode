package myleetjava.sourcecodeleet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosum {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(twoSum(new int[]{2, 7, 11, 15},22))));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                //System.out.println("aaa:"+hashtable.get(target-nums[i]));
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
