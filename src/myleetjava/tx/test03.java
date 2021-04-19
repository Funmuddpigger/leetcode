package myleetjava.tx;

public class test03 {
    public static void main(String[] args) {
        System.out.println(equalOrNot("aabbcc","bbccdd"));
    }

    public static boolean equalOrNot(String A ,String B){
        //先判断奇偶
        int len = A.length();
        String a1 ="";
        String a2 ="";
        String b1="";
        String b2 ="";
        if(len%2!=0){
            isOdds(A,B);
        }
        while(len%2==0&&len>1){
            if(isDouble(A,B)){
               return true;
            }
                len = len/2;
        }
        if(len%2!=0){
            if(isOdds(A,B)){
                return true;
            }
        }
        return false;
    }
        //偶数判断
        public static boolean isDouble(String A,String B){
            String a1 = cutFirst(A);
            String a2 = cutSecond(A);
            String b1 = cutFirst(B);
            String b2 = cutSecond(B);
            if(isDouble(a1,b1)&&isDouble(a2,b2)){
                return true;
            }else if(isDouble(a1,b2)&&isDouble(a2,b1)){
                return true;
            }
        return false;
        }

        //奇数判断
        public static boolean isOdds(String A,String B){
            int len = A.length();
            for(int i =0;i<len;i++){
                if(A.charAt(i)!=B.charAt(i)){
                    return false;
                }
            }
            return true;
        }

        //截取前半截
        public static String cutFirst(String A){
            int len = A.length();
            String s = A.substring(0, len / 2);
            return s;
        }

        //截取后半截
        public static String cutSecond(String A){
            int len = A.length();
            String s = A.substring(len/2,len);
            return s;
        }

}
