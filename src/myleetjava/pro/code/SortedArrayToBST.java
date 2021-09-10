package myleetjava.pro.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortedArrayToBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Object> list = new ArrayList<>();
        while(scan.hasNext()){
            list.add(scan.next());
        }
        Integer[] integers = list.toArray(new Integer[list.size()]);
        System.out.println(sortedArrayToBST(integers));
    }

    /**
     * 1. 根据传入的数组,首先找出最中间的值,作为根节点,该节点的前驱和后继就是他的左右节点
     * 2. 在重复第一步继续构建
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(Integer[] nums) {
        if (nums.length == 0)
            return null;
        return buildTree(nums,0,nums.length-1);
    }

    public static TreeNode buildTree(Integer[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildTree(nums,start,mid-1);
        treeNode.right = buildTree(nums,mid+1,end);
        return treeNode;
    }

}
