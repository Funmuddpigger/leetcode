package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    public static void main(String[] args) {

    }

    public static int[]  intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);Arrays.sort(nums2);
        int one = 0,two = 0;
        List<Integer> res = new ArrayList<>();
        while(one<len1&&two<len2){
            if(nums1[one]==nums2[two]){
                res.add(nums1[one]);
                one++;
                two++;
            }else if(nums1[one]<nums2[two]){
                one++;
            }else{
                two++;
            }
        }
        int count = res.size();
        int[] resArr = new int[count];
        if(count>0){
            for(int i = 0;i<count;i++){
                resArr[i] = res.get(i);
            }
        }
        return resArr;
    }
}
