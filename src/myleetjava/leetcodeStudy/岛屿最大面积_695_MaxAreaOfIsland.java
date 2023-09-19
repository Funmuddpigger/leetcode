package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2022/12/30 9:47
 */
public class 岛屿最大面积_695_MaxAreaOfIsland {

    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        //遍历二维数组
        for(int i = 0;i <grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                //判断当前是不是等于1,1是陆地板块,才进行调用
                if(grid[i][j] == 1){
                    max =Math.max(searchDDFS(grid, i, j),max);
                }
            }
        }
        return max;
    }

    public static int searchDDFS(int[][] grid,int i,int j){
        //判断是否超出边界
        if(!isInArea(grid,i,j)){
            return 0;
        }
        //判断是否是陆地,且未遍历
        if(grid[i][j] != 1){
            return 0;
        }
        //把当前遍历的陆地设置为2
        grid[i][j] = 2;
        //当前的,加上四个方向,也就是该方块的上下左右方向
        return 1 + searchDDFS(grid,i +1,j) + searchDDFS(grid,i-1,j)
                + searchDDFS(grid, i, j+1) + searchDDFS(grid, i, j-1);
    }

    /**
     * 判断是否出界,也就是是否超出图的范围
     */

    public static boolean isInArea(int[][] grid,int i,int j){
        if(i >=0 && j >=0 && i < grid.length && j<grid[0].length){
            return true;
        }
        return false;
    }

}
