package myleetjava.leetcodeStudy;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/8/25 16:01
 */
public class 除自身以外数组的乘积_238_productExceptSelf {

    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(ints);
    }

    /**
     * 逐个计算，左右前缀数组，由于边界处理位置，比如num[0]和nums[max]他们左/右前缀的乘积只能是1，因为没有
     * 对于res数组，只需要把num[i]的L[i]*R[i]即可
     * L[i] = L[i-1]*nums[i-1]，R[i] =R[i+1]*nums[i+1]
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len], L= new int[len],R = new int[len];
        //赋予边界值
        L[0] =1;R[len-1] = 1;
        //从第2个数开始遍历,填充L左前缀数组
        for (int i = 1;i<len;i++){
            L[i] = L[i-1]*nums[i-1];
        }
        //从倒数2个数开始遍历,填充L左前缀数组
        for (int j = len-2;j>=0;j--){
            R[j] = L[j+1]*nums[j+1];
        }
        //合并
        for(int z = 0;z<len;z++){
            res[z] = L[z]*R[z];
        }
        return res;
    }

}
