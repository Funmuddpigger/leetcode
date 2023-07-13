package leetcode.code;

public class 字符串相乘_43_multiply {

    public static void main(String[] args) {
        System.out.println(multiply("123456789","987654321"));
    }

    public static String multiply(String num1, String num2) {
        boolean tags = false;
        char first = num1.charAt(0);
        char second = num2.charAt(0);
        if(first == 0 || second == 0){
            return "0";
        }else if((first == '-' && second != '-') || (first != '-' && second == '-')){
            tags = true;
        }

        if(first == '-'){
            String[] x = num1.split("-");
            num1 = x[1];
        }
        if(second == '-'){
            String[] x = num2.split("-");
            num2 = x[1];
        }

        String s1 = Integer.toBinaryString(Integer.valueOf(num1));
        String s2 = Integer.toBinaryString(Integer.valueOf(num2));

        //遍历乘数s2,逢1则被乘数左移--t(遍历次数)-1 位
        int sum = 0 , t = 0;
        for(int i = s2.length()-1;i>=0;i--,t++){
            if(s2.charAt(i)=='1'){
                int i1 = Integer.parseInt(s1, 2) << t;
                sum = sum + i1;
            }
        }
        String res;
        if(tags){
             res = "-" + sum;
        }else {
            res = sum + "";
        }
        return res;
    }
}
