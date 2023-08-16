package myleetjava.leetcodeStudy;

import java.util.Arrays;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/8/11 10:06
 */
public class H指数_274_hIndex {

    public static void main(String[] args) {

    }

    /**
     * 类似找出数组里的最大的众数
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        /**
         * 限制条件：
         *   至少有h篇文章，被至少引用了h次，即 6 5 3 1 0 ----> h为3（6 5 3）
         */
        int len = citations.length;
        Arrays.sort(citations);
        int h = 0;
        for (int i = len-1; i >=0 ; i--) {
            if (citations[i]>h){
                h++;
            }
        }
        //遍历
        return h;
    }

    //计数排序
    /**
     * 利用计数排序，对文章引用次数进行排序
     * 最后遍历基数排序的数组
     * 由于限制条件：
     *  h不会大于发表文章数，也就是数组长度，可以忽略这部分数据
     *
     *  所以范围只会在[0,len]
     */
    public int hIndex2(int[] citations) {
        int len = citations.length;
        //新建计数排序对应数组
        int[] counters = new int[len + 1];
        //忽略多出数据
        for (int i = 0; i <len ; i++) {
            if(citations[i]<=len){
                //范围内，计数数组的值+1
                counters[citations[i]]++;
            }else{
                //范围外，最大值+1
                counters[len]++;
            }
        }
        int res = 0;
        //遍历
        //counters数组大从到小遍历，跟上述第一种排序后遍历一样的思想，目的都是找最大的h
        // ccounter 中得到大于或等于当前引用次数 的总论文数。当我们找到一个 H 指数时跳出循环，并返回结果
        //也就是这个H占据了大多数的“至少”
        for(int j = len;j>=0;j--){
            //counters[j]就是代表有多少篇论文被至少引用了j次
            res += counters[j];
            if (res>=j){
                return j;
            }
        }
        return 0;
    }
}
