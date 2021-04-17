package myleetjava.leetcodeStudy;

//leetcode 旋转图像
public class RotateSquare {
    public static void main(String[] args) {
        int[][] c = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(c);
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        //上下
        for(int j=0;j<len/2;j++){
            for(int i=0;i<len;i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[len-j-1][i];
                System.out.println(matrix[0][i]);
                matrix[len-j-1][i] = temp;
            }
        }
        //对角线
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j]=temp;
                System.out.println(matrix[j][i]);
            }
        }
    }
}
