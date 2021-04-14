package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static int[] plusOne(int[] digits){
        List<Integer> list = new ArrayList<>();
        int len = digits.length;
        int x = 0;
        boolean needAdd = true;
        for(int i=len-1;i>=0;i--){
            if(needAdd){
                x = digits[i]+1;
                if(x>=10){
                    x=0;
                }else{
                    needAdd = false;
                }
            }else{
                x = digits[i];
            }
            list.add(0,x);
        }
        if(needAdd){
            list.add(0,1);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 如果遇到 9 则+1后必为10,则往前进一位,如果不是9,则+1后直接退出,其他数字不变
     * 超出数组长度的,直接new 一个新数组,长度+1,其他全为0
     */
    public int[] plusOne2(int[] digits) {
        int i = digits.length-1;
        while(i>=0){
            if(++digits[i] !=10){
                return digits;
            }else{
                digits[i]=0;
                i--;
            }
        }

        int[] res = new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
