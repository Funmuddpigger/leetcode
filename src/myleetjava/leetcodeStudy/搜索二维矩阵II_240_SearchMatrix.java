package myleetjava.leetcodeStudy;

public class 搜索二维矩阵II_240_SearchMatrix {
    public static void main(String[] args) {
        //System.out.println(searchMatrix2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},13));
        System.out.println(searchMatrix2(new int[][]{{-5}},-10));
    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int left = 0;
        int len = matrix.length;
        int right = matrix[0].length-1;
        int high = matrix.length-1;
        int low = 0;
        int start = (high - low)/2;
        while(left<=right){
            int mid = (right - left)/2 +left;
            System.out.println("row : " + matrix[0][mid]);
            if(matrix[start][mid]==target){
                return true;
            }else if(len <=1 ){
                    if(matrix[0][mid]>target){
                        right = mid -1;
                    }
                    if(matrix[0][mid]<target){
                        left = mid +1;
                    }
            }else{
                while(low<=high){
                    int hmid = (high - low)/2+low;
                    System.out.println("hmid : "+ hmid);
                    if(matrix[hmid][mid]==target){
                        return true;
                    }
                    if(matrix[hmid][mid]>target){
                        high = hmid -1;
                    }
                    if(matrix[hmid][mid]<target){
                        low = hmid +1;
                    }
                    System.out.println("coloum : " + matrix[hmid][mid]);
                }
                if(matrix[0][mid]>target){
                    right = mid -1;
                }
                if(matrix[0][mid]<target){
                    left = mid +1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int col = 0, row = matrix.length - 1;
        while(row >= 0 && col < matrix[0].length){
            if(row >= 0 && col < matrix[0].length&&matrix[row][col]==target){
                return true;
            }
            if(row >= 0 && col < matrix[0].length&&matrix[row][col]>target){
                row--;
            }
            if(row >= 0 && col < matrix[0].length&&matrix[row][col]<target){
                col++;
            }
        }
        return false;
    }
}
