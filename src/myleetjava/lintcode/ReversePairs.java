package myleetjava.lintcode;

// 532 逆序对
public class ReversePairs {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{2, 4, 1, 3, 5}));
    }
    public static long reversePairs(int[] A) {
        // write your code here\
        int sum = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for(int j = i+1;j<len ;j++){
                if(A[i]>A[j]){
                    sum++;
                }
            }
        }
        return sum;
    }

}
