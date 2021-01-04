package myleetjava.sourcecodeleet;

//leetcode 6.Z字形变换
public class Convert {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        //根据题目描述，可以得知,第一行出现的每个字母是相隔 numRows-1(第一列的个数除去第一行包含的字符)
        // 加上 numRows-2(除了第一行,中间连接Z的那几行的字符总数) 就是第一行相隔的总数,
        int strDis = numRows*2-2,len = s.length(); //相隔的距离,距离加一是因为要算上当前自己,取下标   长度
        StringBuilder str = new StringBuilder(); //builder 比 buffer 要快

        if(numRows<=1){
            return s;
        }

        for(int row=0;row<numRows;row++){
            //j就是第row行的第j个字符
            for(int j=0;j+row<len;j=j+strDis){
                str.append(s.charAt(j+row));
                if(row!=0&&row!=numRows-1&&j + strDis - row<len){
                    str.append(s.charAt(j + strDis - row));  //添加中间Z斜线上的的字符
                }
            }
        }
        return str.toString();
    }
}
