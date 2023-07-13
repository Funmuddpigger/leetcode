package leetcode.code;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/7/7 10:45
 */
public class 统计上升四元组_2552_CountQuadruplets {

    public static void main(String[] args) {
        System.out.println(countQuadrupletsThird(new int[]{1, 3, 2, 4, 5}));
    }

    static void calcLessSquare(int[] nums, int[][] less, int len){
        //初始化第一排数据，less[0][i]代表第0个数前面的数中小于i的数
        for(int i = 1;i<len;i++){
            less[0][i] = 0;
        }
        //枚举j从 1 ~ i-1，如果有nums[j]>nums[i],则在less[i-1][j]上+1
        for (int i = 1;i<len;i++){
            //记录less
            int tmp = nums[i-1];
            for(int j = 1;j<len;j++){
                if (tmp < j){
                    //如果小于，则在上一个已经计算好的小于nums[i-2]的个数+1
                    less[i][j] = less[i-1][j] + 1;
                }else{
                    //否则不变
                    less[i][j] = less[i-1][j];
                }
            }
        }
    }

    static void calcBiggerSquare(int[] nums, int[][] bigger, int len){
        //初始化最后一排数据，bigger[0][i]代表第0个数后面的数中大于i的数
        for(int i = 1;i<=len;i++){
            bigger[len-1][i] = 0;
        }
        //逆序枚举len-2到0的数
        for(int i = len-2;i>=0;i--){
            int tmp = nums[i+1];
            for (int j = 1;j<=len;j++){
                if (tmp > j){
                    bigger[i][j] = bigger[i+1][j] +1;
                }else{
                    bigger[i][j] = bigger[i+1][j];
                }
            }
        }
    }


    public static long countQuadrupletsFourth(int[] nums) {
        int j, k;
        int len = nums.length;
        int[][] less = new int[4001][4001];
        int[][] bigger = new int[4001][4001];
        calcLessSquare(nums, less,len);
        calcBiggerSquare(nums, bigger,len);
        //长度

        int res = 0;
        //循环,仅仅遍历中间两个数
        for(j = 1; j < len; j++){
            for(k = j+1;k < len;k++) {
                //当nums[k] > nums[j],则必然不满足上升四元组条件
                if (nums[k] < nums[j]) {
                    res +=less[j][ nums[k] ] * bigger[k][ nums[j] ];
                }
            }
        }
        return res;
    }

    public static long countQuadrupletsThird(int[] nums) {
        int i, j, k, l;
        //长度
        int len = nums.length;
        int res = 0;
        //循环,仅仅遍历中间两个数
        for(j = 1; j < len; j++){
            for(k = j+1;k < len;k++){
                //当nums[k] > nums[j],则必然不满足上升四元组条件
                if(nums[k]>=nums[j]){
                    continue;
                }
                //否则记录比num[j]小的个数
                int less = 0;
                for(i = 0;i < j;i++){
                    if(nums[k]>nums[i]){
                        less++;
                    }
                }
                //找出比num[k]大的数
                int bigger = 0;
                for(l = k+1;l < len;l++){
                    if(nums[l]>nums[j]){
                        bigger++;
                    }
                }
                //less和bigger中可以随意组合成任意上升四元组，所以乘法原则,让每一层相加
                res += less * bigger;
            }
        }
        return res;
    }

    public static long countQuadrupletsSecond(int[] nums) {
        int i, j, k, l;
        //长度
        int len = nums.length;
        int res = 0;
        //循环
        for (i = 0; i < len; i++) {
            //从i后面开始遍历
            for (j = i + 1; j < len; j++) {
                //从j后面开始遍历
                //只有小于在进入下一层循环
                for (k = j + 1; k < len; k++) {
                    if (nums[i] >= nums[k]) continue;
                    if (nums[k] >= nums[j]) continue;
                    //从k后面便利
                    for (l = k + 1; l < len; l++) {
                        if (nums[j] < nums[l]) {
                            res++;
                        }
                    }
                }
            }

        }
        return res;
    }

    //最简单，时间复杂度高
    public static long countQuadrupletsFirst(int[] nums) {
        int i, j, k, l;
        //长度
        int len = nums.length;
        int res = 0;
        //循环
        for (i = 0; i < len; i++) {
            //从i后面开始遍历
            for (j = i + 1; j < len; j++) {
                //从j后面开始遍历
                for (k = j + 1; k < len; k++) {
                    //从k后面便利
                    for (l = k + 1; l < len; l++) {
                        if (nums[i] < nums[j] && nums[j] < nums[k] && nums[k] < nums[l]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

}
