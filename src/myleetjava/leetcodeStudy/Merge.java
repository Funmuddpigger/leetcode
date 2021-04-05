package myleetjava.leetcodeStudy;

//leetcode 88. 合并两个有序数组
public class Merge {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{4,5,6},3);
    }

    /**
     *从两个数组的尾部开始遍历，寻找他们两组之间当前最大的，因为有序，所以最大的可以从最尾部的位置放入，然后重复遍历，因为是
     * 第二个数组插入到第一个数组，所以while条件就是two>0，而三目运算符的 条件就是判断nums2的数组有没有全部放入
     * 知道nums全部插入才结束循环
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int one = m-1;
        int two = n-1;
        int node = nums1.length-1;
        while(two>=0){
                nums1[node] = (one>=0&&nums1[one]>=nums2[two]?nums1[one--]:nums2[two--]);
                node--;
        }
    }
}