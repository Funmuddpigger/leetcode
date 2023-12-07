package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/11/20 14:31
 */
public class 螺旋矩阵_54_spiralOrder {

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{6,9,7}};
//        int[][] matrix = {{7},{9},{6}};
//        int[][] matrix = {{2,5,8},{4,0,-1}};
        int[][] matrix = {{2,3}};
        spiralOrder(matrix);
    }

    /**
     * 逐层遍历
     * 由二维数组的特性可知道这个矩阵一开始的长宽,也就可以知道这个数组每次遍历的开始和结束下标
     * 可以把这个螺旋矩阵拆开一层一层,每一层从外到内都是一个拥有各自长宽的矩形
     * 每次遍历一圈之后,只需要把最外面的一层去掉,也就是把长和宽 -1 即可
     * 直至为0,退出循环
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        //获取长宽
        int height = matrix.length;
        int width = matrix[0].length;
        //开始,结束遍历下标
        int startWidthIdx = 0,endWidthIdx = width-1,startHeightIdx = 0,endHeightIdx = height -1;
        //返回数组
        List<Integer> nums = new ArrayList<>(height * width);
        //nums全局下标位置
        int idx = 0;
        //开始遍历
        while (width>0&&height>0){
            idx = foreachMatrix(startWidthIdx,endWidthIdx,matrix,nums,idx,startHeightIdx,endHeightIdx);
            startWidthIdx++;endWidthIdx--;
            startHeightIdx++;endHeightIdx--;
            width-=2;height-=2;
        }
        return nums;
    }

    public static int foreachMatrix(int startWidthIdx,int endWidthIdx,int[][] matrix,List<Integer> nums,int idx,int startHeightIdx,int endHeightIdx){
        //先遍历最上面的边
        for(int i = startWidthIdx;i<=endWidthIdx;i++){
            nums.add(idx++,matrix[startWidthIdx][i]);
        }
        if(startHeightIdx!=endHeightIdx){
            //先遍历最右面的边,剔除重合的点位
            for(int j = startHeightIdx+1;j<=endHeightIdx;j++){
                nums.add(idx++,matrix[j][endWidthIdx]);
            }
            //先遍历最下面的边,剔除重合的点位
            for(int x = endWidthIdx-1;x>=startWidthIdx;x--){
                nums.add(idx++,matrix[endHeightIdx][x]);
            }
            if(endWidthIdx!=startWidthIdx){
                //先遍历最左面的边,剔除重合的点位
                for(int y = endHeightIdx-1;y>startHeightIdx;y--){
                    nums.add(idx++,matrix[y][startWidthIdx]);
                }
            }
        }
        return idx;
    }
}
