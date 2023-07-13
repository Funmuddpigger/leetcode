package myleetjava.leetcodeStudy;

//leetcode 38外观数列
public class 外观数列_38_CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }
    //纯递归写法
    static StringBuilder str = new StringBuilder("1");
    public static String countAndSay(int n) {
        StringBuilder temp = new StringBuilder();
        int left =0,right = 0,count = 0,len = str.length();
        if(n<=1){
            return str.toString();
        }else{
            while(right<len){
                if(right!=len-1&&str.charAt(left)==str.charAt(right)){
                    right++;
                    count++;
                }else if(right==len-1&&str.charAt(left)==str.charAt(right)){
                    temp.append(count+1);
                    temp.append(str.charAt(left));
                    count=0;
                    right++;
                }else{
                    temp.append(count);
                    temp.append(str.charAt(left));
                    count=0;
                    left=right;
                }
            }
            str = temp;
            return countAndSay(n-1);
        }
    }

    //leetcode 编译器好像不支持static,所以这是不用递归的写法
    public static String countAndSay2(int n) {
        StringBuilder str = new StringBuilder("1");
        while(n>1){
            StringBuilder temp = getStr(str);
            str = temp;
            n--;
        }
        return str.toString();
    }
    public static StringBuilder getStr(StringBuilder str){
        int left =0,right = 0,count = 0,len = str.length();
        StringBuilder temp = new StringBuilder();
        while(right<len){
            if(right!=len-1&&str.charAt(left)==str.charAt(right)){
                right++;
                count++;
            }else if(right==len-1&&str.charAt(left)==str.charAt(right)){
                temp.append(count+1);
                temp.append(str.charAt(left));
                count=0;
                right++;
            }else{
                temp.append(count);
                temp.append(str.charAt(left));
                count=0;
                left=right;
            }
        }
        return temp;
    }
}
