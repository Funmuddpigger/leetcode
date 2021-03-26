package myleetjava.sourcecodeleet;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        System.out.println("i+"+ removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates2(int nums[]){
        int len = nums.length;
        int left = 0;
        for(int i = 1;i<len;i++){
            if(nums[i] != nums[left]){
                left++;
                nums[left] = nums[i];
            }
        }
        for (int i = 0; i < left+1; i++) {
            System.out.println(nums[i]);
        }
        return left;
    }
}
