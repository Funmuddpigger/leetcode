package myleetjava.pro.code;

import java.util.HashMap;
import java.util.Map;

public class MaxDepth {

    public static void main(String[] args) {
        TreeNode rl2 = new  TreeNode(15,null,null);
        TreeNode rr2 = new  TreeNode(7,null,null);
        TreeNode l1 = new  TreeNode(9,null,null);
        TreeNode r1 = new  TreeNode(20,rl2,rr2);
        TreeNode root = new  TreeNode(3,l1,r1);
        System.out.println(maxDepth(root));
    }
    //Definition for a binary tree node.
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
    //dfs法
    public static int maxDepth(TreeNode root) {
         //start from root
        int depth = 1;
        if(root==null){
            return 0;
        }
        //from root head==null
        Map<TreeNode,Boolean> map = new HashMap<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root,null);
        int res = search(root,depth,map,parent,0);
        return res;
    }

    public static int search(TreeNode root, int depth, Map<TreeNode, Boolean> map,
                             Map<TreeNode,TreeNode> parent,int max){
        if(root == null ){
            return max;
        }else if(root.left!=null && !map.containsKey(root.left)){
            map.put(root.left,true);
            parent.put(root.left,root);
            depth++;
            root = root.left;

        }else if(root.right!=null && !map.containsKey(root.right)){
            map.put(root.right,true);
            parent.put(root.right,root);
            depth++;
            root = root.right;
        }else {
            root = parent.get(root);
            if(depth>max){
                max = depth;
            }
            depth--;
        }
        return search(root,depth,map,parent,max);
    }

}
