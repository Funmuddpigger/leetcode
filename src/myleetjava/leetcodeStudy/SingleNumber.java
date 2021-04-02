package myleetjava.leetcodeStudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[11];
        for(int i=0;i<11;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums){
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num = num^nums[i];
        }
        return num;
    }

    public static int singleNumber2(int[] nums){
        Map<Integer,Integer> res = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(res.containsKey(nums[i])){
               res.replace(nums[i],res.get(nums[i])+1);
            }else{
                res.put(nums[i],1);
            }
        }
        for(int key : res.keySet()){
            if(res.get(key).equals(1)){
                return key;
            }
        }

        return -1;
    }
}
