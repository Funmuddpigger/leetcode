package myleetjava.sourcecodeleet;

public class LongestOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
    public static int longestOnes(int[] A, int K) {
        int left = 0,right = 0,total=0;
        int len = A.length,res=0;
        while(right<len){
            if(A[right]==0) {
                total++;
            }
            while(total>K){
                if(A[left++]==0) {
                    total--;
                }
            }
            res= Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
