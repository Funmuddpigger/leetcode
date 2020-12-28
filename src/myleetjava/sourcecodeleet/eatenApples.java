package myleetjava.sourcecodeleet;

import java.util.Comparator;
import java.util.PriorityQueue;

public class eatenApples {
    public static void main(String[] args) {
        System.out.println(new eatenApples().getAppleDay(new int[]{1,2,3,5,2},new int[]{3,2,1,4,2}));
    }

    public int getAppleDay(int apples[],int days[]){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        for(int i = 0;i < apples.length || queue.size()>0;i++){
            //排除过期
            while(!queue.isEmpty()){
                int[] peek = queue.peek();
                if(peek[1]<=i){
                    queue.poll();
                }else{
                    break;
                }
            }
            //添加苹果
            if(i<apples.length&&apples[i]>0){
                //System.out.println(i<apples.length&&apples[i]>0);
                queue.add(new int[]{ apples[i] , days[i]+i });
            }
            //吃苹果
            int[] peek = queue.peek();
            //System.out.println(peek[0]+":"+peek[1]);
            if(peek != null&&peek[0] >0 ){
                ans++;
                peek[0]--;
                if(peek[0]==0){
                    queue.poll();
                }
            }
        }
        return ans;
    }
}
