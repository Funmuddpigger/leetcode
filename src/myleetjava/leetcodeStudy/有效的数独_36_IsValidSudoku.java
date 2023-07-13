package myleetjava.leetcodeStudy;

import java.util.*;

public class 有效的数独_36_IsValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},
                                                      {'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','3'},{'.','1','5','.','.','.','.','.','.'},
                                                      {'.','.','.','.','.','2','.','.','.'}, {'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}}));
    }
    //row column 3*3 逐个遍历
    public static boolean isValidSudoku(char[][] board) {
        int count = 0,isThree = 0,col=0,ro =0;
        for(int times = 0; times<9;times++){
            for(int column = 0; column<9;column++){
                Set<Character> setRes = new HashSet<>();
                for(int i = 0;i<9;i++){
                    //System.out.println("row: "+ i +"column: "+ column);
                    //System.out.println(board[i][column]);
                    if(Character.isDigit(board[i][column])&&!setRes.add(board[i][column])){
                        System.out.println(board[i][column]);
                        return false;
                    }
                }
            }
            for(int row = 0; row<9;row++){
                Set<Character> setRes = new HashSet<>();
                for(int i = 0;i<9;i++){
                    //System.out.println("row: "+ row +"column: "+ i);
                    //System.out.println(board[row][i]);
                    if(Character.isDigit(board[row][i])&&!setRes.add(board[row][i])){
                        System.out.println(board[row][i]);
                        return false;
                    }
                }
            }
        }
        //3*3
        while(count<9){
            Set<Character> setRes = new HashSet<>();
            for(int i=0+3*ro;i<3+3*ro;i++){
                for(int j=0+3*col;j<3+3*col;j++){
                        //System.out.println("row: "+ i +"column: "+ j + "three: " + isThree + "col: "+col);
                        //System.out.println(board[i][j]);
                        if(Character.isDigit(board[i][j])&&!setRes.add(board[i][j])){
                            //System.out.println(board[i][j]);
                            return false;
                        }

                }
            }
            if(isThree == 2){
                isThree = -1;
                col =-1;
                ro++;
            }
            col++;
            isThree++;
            count++;
        }
        return true;
    }

    public static boolean sweep(char[][] board,int len,int row,int column){
        Set<Character> setRes = new HashSet<>();
        for(int i = 0;i<len;i++){
            System.out.println("row: "+ row +"column: "+ column);
            System.out.println(board[row][column]);
            if(Character.isDigit(board[row][column])&&!setRes.add(board[row][column])){
                System.out.println(board[row][column]);
                return false;
            }
        }
        return true;
    }
}
