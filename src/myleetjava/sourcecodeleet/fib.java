package myleetjava.sourcecodeleet;

//leetcode 509 斐波拉契
public class fib {
    public static void main(String[] args) {
        System.out.println(fib2(5));
    }

    public static int fib(int n) {

        if(n<2){
            return n;
        }
        int p = 0, q = 0,r=1;
        for(int i=2;i<=n;i++){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }

    public static int fib2(int n) {

        if(n<2){
            return n;
        }
        System.out.println((n-1)+"+"+(n-2));
        return fib2(n-1)+fib2(n-2);
    }
}
