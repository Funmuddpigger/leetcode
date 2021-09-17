package myleetjava.pro.code;

import java.util.LinkedList;

public class NumIslands {
    public int numIslands(char[][] grid) {
        /**
         * 初始化数据,一个visit数组记录访问节点,一个stack执行DFS进出操作,sum记录数据
         */
        int m = grid.length,n = grid[0].length,sum = 0;
        boolean visit[][] = new boolean[m][n];
        LinkedList stack = new LinkedList();

        /**
         * 开始执行遍历
         */
        for(int i =0;i<m;i++){
            for(int j =0; j < n; j++){
                /**
                 * 是 1 ,就是岛 ,开始 DFS,count 统计次数,>= 2 个就是岛屿 ,sum +1
                 * 从该节点的 右边开始,然后下边,然后左,然后右边
                 */
                if(!visit[i][j]&&grid[i][j]==1){
                    visit[i][j] = true;
                    int count = 0;
                    if(!visit[i][j]&&grid[i][j+1]==1){

                    }else if(!visit[i][j]&&grid[i+1][j]!=0){

                    }else if(!visit[i][j]){

                    }else{

                    }
                }
            }
        }
    return 0 ;
    }
}
