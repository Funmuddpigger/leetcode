package myleetjava.sourcecodeleet;

public class searchInsert2 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 7, 8, 9},100));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        int ans = nums.length;
        while(left<=right){
            mid = (left+right)>>1;
            if(target<=nums[mid]){
                ans = mid;
                right = mid-1;

            }
            if(target>nums[mid]){
                left = mid+1;
            }
        }
        return ans;
    }
}
