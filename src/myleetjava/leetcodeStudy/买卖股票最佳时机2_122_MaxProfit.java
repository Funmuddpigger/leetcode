package myleetjava.leetcodeStudy;

//leetcode 122.买卖股票最佳时机2  122. Best Time to Buy and Sell Stock II
public class 买卖股票最佳时机2_122_MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }

    public static int maxProfit(int nums[]){
        int len = nums.length;
        int sum = 0;
        for(int i=1;i<len;i++){
           if(nums[i]>nums[i-1]){
               sum = sum + nums[i]-nums[i-1];
           }
        }
        return sum;
    }

    //Finding minima and store buy, find a maxima and store sell.
    public static int maxProfit2(int nums[]){
        int n = nums.length;
        if(n==0) return 0;
        int ans = 0;
        int i =0;
        while(i<n){
            while(i+1<n && nums[i]>=nums[i+1]){
                i++;
            }
            int buy=i;
            while(i+1<n && nums[i]<nums[i+1]){
                i++;
            }
            int sell = i;
            ans +=(nums[sell]-nums[buy]);
            if(buy==n-1) break;
        }
        return ans;
    }

}
