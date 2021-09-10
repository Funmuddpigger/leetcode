package myleetjava.pro.code;

import java.util.*;

public class CountPrimes {
    public static void main(String[] args) {

    }

    /**
     * 质数都是从2开始才有的,从前遍历,如果第一个能整除的是自身,则一定是质数,否则不是
     * 由于 x 能被 y 整除的话(因子) , 则有 x/y 也可以被 x 整除x=14,y=7 14/7 =2  14可以被2整除
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count =0;
        if(n<2){
            return 0;
        }
        for(int i=2;i<n;i++){
           count =  isPrimes(i) ? ++count : count;
        }
        return count;
    }

    /**
     * 判断 i 是否能被 [2,根号i]的区间范围内的数整除,有则一定不是质数
     * @param i
     * @return
     */
    public boolean isPrimes(int i){
        for(int j=2;j*j<=i;j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }

    /**
     * 从小到大开始标记,因为当某个数x 不是质数(合数),那他的公因式一定是某个小于 x 的质数 y
     * 的整数倍,故根据此方法的步骤，我们在遍历到 y 时，就一定会在此时将 x 标记为
     * isPrime[x]=0
     * 我们只需要从 x*x的地方开始标识 ,因为 2x,3x ,4x....在此之前都被2,3标注了
     * @param n
     * @return
     */
    public int countPrimes2(int n){
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int count = 0;
        for(int i=2;i<n;i++){
            /**
             * 从2开始,2一定是素数,则会把2相关的倍数都标记为 合数 (0)
             */
            if(isPrime[i]==1){
                count++;
                /**
                 * 标记改质数的倍数
                 * (long) -防止过大
                 */
                if((long)i*i<n){
                    for(int j=i*i;j<n;j=j+i){
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }

}
