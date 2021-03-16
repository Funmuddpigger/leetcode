package myleetjava.sourcecodeleet;

import java.util.*;

public class Mid {

    public static void main(String[] args) {
        System.out.println(getMid(new int[]{5,7,9,1,4,6}));
    }

    public synchronized static double getMid(int[] A){
        int len = A.length;
        double res ;
        Arrays.sort(A);
        if (len%2 == 0){
            return (A[len>>>1]+A[(len>>>1)-1] )/2.0;
        }
        return A[(len-1)>>>1];
    }
}
