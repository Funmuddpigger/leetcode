package myleetjava.leetcodeStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Administrator
 * @description：TODO
 * @date ：2024/4/3 10:22
 */
public class 从前序与中序遍历序列构造二叉树_105_buildTree {

    public static void main(String[] args) {

    }

    /**
     * 递归构造树
     *  1. 前序遍历的每个子序列的第一个节点可以确定子树的根节点
     *  2. 中序遍历，根节点可以把当前所在数组切分为2半，左边未左子树，右边为右子树
     *  3. 因此，通过递归，不断找到左右子树的根节点就可以完成树的构造
     *    ex：preorder:[3,9,20,15,7]  inorder:[9,3,15,20,7]
     *   按照步骤，3作为根节点，数组切分为 左子树：9 根节点：3  右子树：15，20，7
     *   重复步骤，9作为根节点，数组切分为 左子树：null 根节点：9  右子树：null
     *   另一边，  20作为根节点，数组切分为 左子树：15 根节点：20 右子树 7
     *   因此得出如下树：
     *                              3
     *                             / \
     *                            9   20
     *                               /  \
     *                              15   7
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(Integer[] preorder, Integer[] inorder) {
        List<Integer> inOrderList = Arrays.asList(inorder);
        //新建整个树的根节点
        TreeNode root = new TreeNode(preorder[0]);
        buildBranch(root,preorder[1],inOrderList);
        return null;
    }

    public TreeNode buildBranch(TreeNode root, int node,List<Integer> inOrderList){
        boolean isRootLeft = true;
        //通过中序遍历，找出下一个preOrder中的根节点属于左子树的还是右子树的
        for(int idx = 0;idx < inOrderList.size();idx++){
            //找出i和root各自在中序的下标，判断左右子树
            //先找到根节点，证明在右边
            if(inOrderList.get(idx) == root.val){
                isRootLeft = false;
                break;
            }
            if(inOrderList.get(idx) == node){
                break;
            }
        }
        if(isRootLeft){
            root.setLeft(new TreeNode(node));
        }else{
            root.setRight(new TreeNode(node));
        }
        return null;
    }

}

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

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
