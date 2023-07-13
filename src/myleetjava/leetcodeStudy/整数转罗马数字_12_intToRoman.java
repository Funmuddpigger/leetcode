package leetcode.code;

import java.util.HashMap;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/7/13 10:12
 */
public class 整数转罗马数字_12_intToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(20));
    }

    public static final HashMap<Integer, String> map = new HashMap();
    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        //特殊情况
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static String intToRoman(int num) {
        //要找出能区分特殊情况的方法
        StringBuilder str = new StringBuilder();
        //运行计算器，计算到第几位，对应成多少个10   ex：1994
        int i = 0;
        //简单除法
        while (num != 0) {
            //取出当前数字
            int single = num % 10;
            if(i>0){
                String key = check(i,single);
                str.insert(0, key);
            }else{
                String key = check(single);
                str.insert(0, key);
            }
            num = num / 10;
            i++;
        }
        return str.toString();
    }

    //检查单个数字是否属于已有罗马数字范畴
    public static String check(int single) {
        //判断是否包含已有情况,还得判断i的i情况
        if (map.containsKey(single)) {
            //包含，直接返回
            return map.get(single);
        } else {
            StringBuilder res = new StringBuilder();
            //拆分，先判断是否大于5,先固定5，在往右边加入数字
            if (single > 5) {
                res.append(map.get(5));
                int t = single - 5;
                for (int j = 0; j < t; j++) {
                    res.append(map.get(1));
                }
            } else {
                for (int j = 0; j < single; j++) {
                    res.append(map.get(1));
                }
            }
            return res.toString();
        }

    }

    //检查单个数字是否属于已有罗马数字范畴
    public static String check(int i, int single) {
        int pow = (int) Math.pow(10, i);
        //判断是否包含已有情况,还得判断i的i情况
        if (map.containsKey(single)) {
            //包含，直接返回

            return map.get(single * pow);
        } else {
            StringBuilder res = new StringBuilder();
            //拆分，先判断是否大于5,先固定5，在往右边加入数字
            if (single > 5) {
                res.append(map.get(5 * pow));
                int t = single - 5;
                for (int j = 0; j < t; j++) {
                    res.append(map.get(1 * pow));
                }
            }else{
                for (int j = 0; j < single; j++) {
                    res.append(map.get(1 * pow));
                }
            }
            return res.toString();
        }
    }
}
