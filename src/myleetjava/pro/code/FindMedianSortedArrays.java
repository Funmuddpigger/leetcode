package myleetjava.pro.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindMedianSortedArrays {
    public static void main(String[] args) {

    }


    /**
     * 中序---左根右,递归实现,先左子树找到最左节点,出栈输出,在对右子树压栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> res = getInOrderNO2(root,list);
        return res;
    }

    public List<Integer> getInOrder(TreeNode root,List<Integer> list){
        if(root == null){
            return null;
        }
        getInOrder(root.left,list);
        list.add(root.val);
        getInOrder(root.right,list);
        return list;
    }

    /**
     * 通过while循环查找最左子树,不递归
     *找到最左节点后输出val
     *遍历栈内节点,并输出
     *
     * @param root
     * @param list
     * @return
     */
    public List<Integer> getInOrderNO2(TreeNode root,List<Integer> list){
        Deque<TreeNode> sta = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        //寻找最左节点
        while(root!=null||!sta.isEmpty()){
            while (root!=null){
                //入栈,寻找最左节点
                sta.push(root);
                root = root.left;
            }
            /**
             * 当前节点是空,证明上一个节点是目前相对于这个子树的最左节点
             * 出栈,然后重复上面过程继续寻找当前为root的子树的最左
             *
             * 1. 先从栈顶提取元素
             * 2. 先输出这个最左的值
             * 3. 把该节点的右子树在进行第一步的循环
             */
            root = sta.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }

}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
