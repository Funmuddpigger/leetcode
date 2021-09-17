package myleetjava.pro.code;

import java.util.LinkedList;

public class NumIslands {
    public static void main(String[] args) {
        numIslands(new char[][]{{1},{1}});
    }
    public static int numIslands(char[][] grid) {
        /**
         * 初始化数据,一个visit数组记录访问节点,一个stack执行DFS进出操作,sum记录数据
         */
        grid[0][0] = '1';
        grid[1][0] = '1';

        int m = grid.length,n = grid[0].length,sum = 0;
        boolean visit[][] = new boolean[m][n];
        /**
         * 开始执行遍历
         */
        for(int i =0;i<m;i++){
            for(int j =0; j < n; j++){
                /**
                 * 是 1 ,就是岛 ,开始 DFS,count 统计次数,>= 2 个就是岛屿 ,sum +1
                 * 从该节点的 右边开始,然后下边,然后左,然后右边
                 */
                if(!visit[i][j]&&grid[i][j]=='1'){
                    //visit[i][j] = true;
                    dfs2(visit, grid, i, j, 1,m,n);
                    sum = sum + 1;

                }
            }
        }
        return sum ;
    }

    public static void dfs(boolean visit[][],char[][] grid,int i , int j,int count,int m ,int n){
        // right
        if((i<m&&i>=0 && j+1<n && j>=0 )&&grid[i][j+1]!='\0'&&!visit[i][j+1]&&grid[i][j+1]=='1'){
            count++;visit[i][j+1]=true;
            dfs(visit,grid,i,j+1,count,m, n);
            //down
        }if((i+1<m && i>=0 && j<n && j>=0 )&&grid[i+1][j]!='\0'&&!visit[i+1][j]&&grid[i+1][j]=='1'){
            count++;visit[i+1][j]=true;
            dfs(visit,grid,i+1,j,count,m , n);
            //left
        }if((i<m && i-1>=0 && j<n && j>=0 )&&grid[i-1][j]!='\0'&&!visit[i-1][j]&&grid[i-1][j]=='1'){
            count++;visit[i-1][j]=true;
            dfs(visit,grid,i-1,j,count,m ,n);
            //up
        }if((i<m && i>=0 && j<n && j-1>=0 )&&grid[i][j-1]!='\0'&&!visit[i][j-1]&&grid[i][j-1]=='1'){
            count++;visit[i][j-1]=true;
            dfs(visit,grid,i,j-1,count,m ,n);
        }
    }

    public static void dfs2(boolean visit[][],char[][] grid,int i , int j,int count,int m ,int n){
        if((i<m&&i>=0 && j<n && j>=0 )&&grid[i][j]!='\0'&&!visit[i][j]&&grid[i][j]=='1'){
            count++;visit[i][j]=true;
            //right
            dfs2(visit,grid,i,j+1,count++,m, n);
            //down
            dfs2(visit,grid,i+1,j,count++,m, n);
            //left
            dfs2(visit,grid,i,j-1,count++,m, n);
            //down
            dfs2(visit,grid,i-1,j,count++,m, n);
        }
        return ;
    }
}
