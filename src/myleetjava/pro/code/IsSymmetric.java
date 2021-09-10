package myleetjava.pro.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IsSymmetric {

    public class TreeNode {
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

    }
    /**
     *   层次遍历一层一层的查,查看是否回文串
     *   1. 如何一层一层的进行判断
     *   2. 如何判断是回文串
     *
     *   两两放入,left.left和right.right,left.right和right.left
     *   即左子树从左到右,右子树从右到左
     *   然后两两出队
     */

    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> link = new LinkedList<>();
        if(root==null){
            return true;
        }
        link.add(0,root.left);
        link.add(0,root.right);
        while(!link.isEmpty()){
            //两两出队比对
            TreeNode treeLeft = link.removeLast();
            TreeNode treeRight = link.removeLast();
            if(treeLeft==null&&treeRight==null){
                continue;
            }
            if((treeLeft==null||treeRight==null)||(treeLeft.val!=treeRight.val)){
                return false;
            }
            link.add(treeLeft.left);
            link.add(treeRight.right);

            link.add(treeLeft.right);
            link.add(treeRight.left);
        }
        return true;
    }
}
