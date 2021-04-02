package myleetjava.threeseven;


//牛顿迭代法
public class NewTon2 {
    public static void main(String[] args) {
        System.out.println(getSqrtCustom(5,2));
    }

    public static double getSqrt(int db,int n){
        double x = 1;
        double x1 =x - (x*x-n)/(2*x);
        while(x-x1<-0.0000000001 || x-x1 > 0.0000000001){
            x = x1;
            x1 = x-(x*x-n)/(2*x);
        }
        return x1;
    }
    public static double getSqrtCustom(int db,int n){
        double dbx=0.1;
        for(int i =0;i<db;i++){
            dbx = dbx * 0.1;
        }
        System.out.println(dbx);
        double x = 1;
        double x1 =x - (x*x-n)/(2*x);
        while(x-x1<(-dbx) || x-x1 > dbx){
            x = x1;
            x1 = x-(x*x-n)/(2*x);
        }
        return x1;
    }
}
