package myleetjava.chart;

import java.util.Arrays;
import java.util.List;

public class Dijkstra {

    public static void main(String[] args) {
        int[][] graph ={
                {-1, 3,-1,-1,-1,-1, 4,-1,-1,-1},
                { 3,-1,11,10, 7,-1,-1,-1,-1,-1},
                {-1,11,-1,20,-1,-1,-1,-1,-1,15},
                {-1,10,20,-1, 9,-1,-1,-1, 8, 2},
                {-1, 7,-1, 9,-1, 8,-1,-1, 4,-1},
                {-1,-1,-1,-1, 8,-1, 9, 2,-1,-1},
                { 4,-1,-1,-1,-1, 9,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1, 2,-1,-1, 1,-1},
                {-1,-1,-1, 8, 4,-1,-1, 1,-1, 6},
                {-1,-1,15, 2,-1,-1,-1,-1, 6,-1}
        };
        System.out.println(dijkstra(graph));
    }

    public static int dijkstra(int[][] grape){
        int startIndex = 0;
        grape[startIndex][startIndex] = 0;
        //得到点的个数
        int points = grape.length;
        //已确定最短路径的点集合
        int[] visit = new int[points];
        //到其他点的路径长度（权重）
        int[] dist = new int[points];
        //初始化未检索的集合
        for(int i = 0;i<points;i++){
            visit[i] = -1;
        }
        //初始化第一个点
        visit[startIndex] = 0;

        //初始化startIndex到其他点的距离,
        for(int i = 0;i < points ;i++){
            dist[i] = grape[startIndex][i];
        }

        //遍历
        for(int j = 1;j<points;j++){
            //更新确定的集合，并且记录当前最短下标
            int minNum = Integer.MAX_VALUE;
            int minindex = startIndex;
            for(int k = 0;k<points;k++){
                //当前dist中有-1的都是为无穷长,以为浏览过,剔除，寻找剩余最短的点，记录其index
                if(dist[k]!=-1&&visit[k]==-1&&minNum>dist[k]){
                    minNum = dist[k];
                    minindex = k;
                }
            }
            //加入确定的集合
            visit[minindex] = minNum;
            //加入新点后，更新dist,遍历新节点到其他点的距离(grape代替)
            for(int column = 0;column < points ;column++){
                //判断是否有权重
                if(grape[minindex][column]!=-1){
                    //判断startindex节点出发或者从最新的minindex（中转点出发）到目标点的距离更小,而原本为-1(不可达),则直接置换新权重
                    int x = dist[minindex] + grape[minindex][column];
                    if(dist[column] == -1 || dist[column]>x){
                        dist[column] = x;
                    }
                }
            }
        }
        int res = 0;
        for (int n = 0;n<points;n++){
            res = res + dist[n];
            System.out.print(dist[n]+"  ");
        }
        return res;
    }
}
