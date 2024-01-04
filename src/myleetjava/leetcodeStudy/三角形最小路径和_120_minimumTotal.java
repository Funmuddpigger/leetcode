package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/1/4 16:42
 */
public class 三角形最小路径和_120_minimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(minimumTotal(lists));
    }
    /**
     * 构建一个二维数组作为矩阵（长和宽为最后一层的元素个数，也就是List.get(LastIdx).size）与传入进来的triangle相同，第一层List的index代表这个三角形的层数（从头向下，第一层idx为0）
     * 第二层List代表每层的第几个元素
     *
     * 题目给出的提示：每一步只能移动到下一行中相邻的结点上,相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
     *
     * 因此根据这个移动规则，我们可以列出dp方程
     * dp[0][0] = List.get(0).get(0);  第一个元素（初始元素）
     * dp[i][j] = Min(dp[i][j-1],dp[i-1][j-1]) + List.get(i).get(j)
     * 这里要注意的是这个矩形是只有一半的，其他的都是0
     *
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        //找出三角形最下层长度
        int len = triangle.size();
        int width = triangle.get(len - 1).size();
        //新建dp矩阵
        int[][] dp = new int[width][width];
        dp[0][0] = triangle.get(0).get(0);
        //最小值初始化
        int min = dp[0][0];
        //开始遍历三角形
        for(int i = 1;i < len;i++){
            //获取每一层
            int size = triangle.get(i).size();
            for(int j = 0;j < size;j++){
                //遍历dp,第一种处于边界，也就是只有一个点可以到达
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                //第二种，不在边界线，但在第二层，也只有一个点可以走
                else if (i == 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                //第三种，有左右父节点可以到达
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }

                //最后一层需要对比min
                if(i == len-1&&j==0){
                    min = dp[i][j];
                }else if(i == len-1&&j!=0){
                    min = Math.min(dp[i][j],min);
                }
            }
        }
        return min;
    }

}
