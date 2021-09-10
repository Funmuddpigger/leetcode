package myleetjava.pro.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,3,4,5,25,24,3,4}));
    }

    /**
     * 从第一个开始,找出当前最优解-------当前柱子,能合除了已经visit过得柱子,还有组成其他最大值
     * 则更新最大值
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0, bold = 0,num=1;
        boolean visit[] = new boolean[height.length];
        Map<Integer, Integer> areas = new HashMap<>();
        Arrays.fill(visit,false);
        visit[bold] = true;
        while (num<=height.length){
           /**
            * 在更新最大值的同时,更新area[当前bold][组成最大的bold]
            */
           for (int i = 1; i < height.length; i++) {
               /**
                * 未遍历过的才进入该循环
                */
               if (!visit[i]) {
                   int area = Math.min(height[bold], height[i]) * Math.abs(i - bold);
                   if (max < area) {
                       max = area;
                       areas.put(bold, i);
                   }
               }
           }
           /**
            * 等于null的时候,证明本次没有比最大值 更大的答案,从仍未visit的点中去一个
            * 重复上述步骤
            */
           Integer nowBold = areas.get(bold);
           if(nowBold!=null){
               visit[nowBold] = true;
               bold = nowBold;
           }else{
               for(int i=1;i<height.length;i++)
                   if(!visit[i]){
                       visit[i] = true;
                       bold = i;
                       break;
                   }
           }
           num++;
       }
       return max;
    }

    /**
     * 双指针,当左右相同时,小的那边进行移动,为什么要移动小的,因为移动大的指针,永远它的高度都是按照最小的那个值来算
     * 导致 min(x,y)*length ,长度每次移动都会减小,不可能更大了
     *
     * 这个左指针对应的数不会作为容器的边界了，那么我们就可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针于原先的右指针之间的左右位置，才可能会作为容器的边界。
     *
     * 这样以来，我们将问题的规模减小了 11，被我们丢弃的那个位置就相当于消失了。此时的左右指针，就指向了一个新的、规模减少了的问题的数组的左右边界
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int max = 0;
        int left =0,right = height.length-1;
        while (left<right){
            int area = Math.min(height[left], height[right]) * (right - left);
            if(max<area){
                max = area;
            }
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
