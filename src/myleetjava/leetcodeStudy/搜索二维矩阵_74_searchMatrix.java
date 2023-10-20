package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/9/22 9:04
 */
public class 搜索二维矩阵_74_searchMatrix {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
    }

    /**
     * 二维转一维,从示例就可以看出这是完全的有序数组，有序查找二分顶上
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        //先拿出矩形数组的宽和高
        int matrixSize = matrix.length;
        int matrixColSize = matrix[0].length;
        //一维数组长度
        int len = matrixSize*matrixColSize;
        //新的一维数组
        int[] tmp = new int[len];
        int idx = 0;
        //遍历,把二维数组转成一维数组
        for(int i = 0;i<matrixSize;i++){
            for (int j = 0; j < matrixColSize; j++) {
                tmp[idx++] = matrix[i][j];
            }
        }
        //二分搜索
        return searchTarget(tmp, target, len) != -1;
    }

    public static int searchTarget(int[] tmp,int target,int len){
        int left = 0,right = len -1;
        //二分循环边界条件
        while(left <= right){
            //防止 (right+left) int数值类型超过MAX.INTEGER
            int mid = left + ((right - left)>>1);
            if (tmp[mid]>target){
                right = mid - 1;
            }else if(tmp[mid]<target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
