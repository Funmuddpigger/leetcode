package myleetjava.leetcodeStudy;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2023/9/19 11:10
 */
public class 两数之和II输入有序数组_167_twoSum {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{5,25,75},100));
    }

    public static int[] twoSum(int[] numbers, int target) {
        //二分，先固定一个点的位置，再去寻找
        for(int i=0;i<numbers.length;i++){
            //二分法实现寻找
            int next = getNextIdx(i+1,numbers.length,numbers,target - numbers[i]);
            if(next!=-999){
                return new int[]{i+1,next+1};
            }
        }
        return null;
    }

    public static int getNextIdx(int startIdx,int endIdx,int[] numbers,int nextTarget){
        while(startIdx<endIdx){
            int mid = (endIdx + startIdx)/2;
            if(numbers[mid]<nextTarget){
                //中位数小于目标值,往右边找
                startIdx = mid +1;
            }else if(numbers[mid]>nextTarget){
                //中位数大于目标值，往左找
                endIdx = mid - 1;
            }else{
                return mid;
            }
        }
        return -999;
    }

    //C语言双指针写法
    /**
     * int* twoSum(int* numbers, int numbersSize, int target, int* returnSize){
     *         int* res = (int*)malloc(sizeof(int)*2);
     *         memset(res,-1,sizeof(int)*2);
     *     *returnSize = 2;
     *
     *         int i = 0;int j = numbersSize-1;
     *         while(i<j){
     *             //num[i] + num[j] < target ，证明头指针的数不够大，头指针后移
     *             //num[i] + num[j] > target ，证明尾指针的数过大，尾指针前移
     *             if(numbers[i] + numbers[j] > target){
     *                 j--;
     *             }else if(numbers[i] + numbers[j] == target){
     *                 res[0] = i +1,res[1]=j+1;
     *                 return res;
     *             }else{
     *                 i++;
     *             }
     *         }
     *         return res ;
     *     }
     */
}
