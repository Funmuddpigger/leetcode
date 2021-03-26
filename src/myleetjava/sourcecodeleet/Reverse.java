package myleetjava.sourcecodeleet;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
    }

    public static int reverse(int x) {
        if(x==0){
            return x;
        }
        if(x<0){
            int swapRes = swap(-1 * x,true);
            return -1*swapRes;
        }
        return swap(x,false);
    }

    public static int swap(int n,boolean boo){
        int res = 0;
        while(n>0){
            if((boo==true && (res>Integer.MIN_VALUE/10 || res==Integer.MIN_VALUE&&n%10<8))
                    ||(boo==false&&(res<=Integer.MAX_VALUE/10||res==Integer.MAX_VALUE && n%10<7))){
                res = res*10+n%10;
                n = n/10;
            }else{
                return 0;
            }
        }
        return res;
    }
}
