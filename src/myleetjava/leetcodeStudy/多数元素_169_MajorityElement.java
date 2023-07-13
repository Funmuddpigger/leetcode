package myleetjava.leetcodeStudy;

//leetcode 169. 多数元素

public class 多数元素_169_MajorityElement {

    /**
     * Boyer-Moore 投票算法
     * 如果我们把众数记为 +1+1，把其他数记为 -1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     */
    public int majorityElement(int[] nums) {
            int king = nums[0];
            int people = 1;
            for(int i =1 ;i<nums.length;i++){
                if(people==0){
                    king = nums[i]; // 人数为0,重新建立,计算
                    people = 1;
                }else if(king==nums[i]){
                    people++;   //人数加一
                }else{
                    people--;  //人数减一
                }
            }
            return king;
        }
}
