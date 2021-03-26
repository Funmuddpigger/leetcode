package myleetjava.sourcecodeleet;

//leetcode 70. 爬楼梯
public class ClimbStairs2 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        int[] save = new int[n+1];
        return climbStairsSave(n,save);
    }

    public static int climbStairsSave(int n , int[] save){
        if(save[n] > 0){
            return save[n];
        }
        if(n==1){
            return save[1]=1;
        }else if(n==2){
            return save[2]=2;
        }else{
            save[n] = climbStairsSave(n-1,save) + climbStairsSave(n-2,save);
        }
        return save[n];
    }
}
