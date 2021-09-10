package myleetjava.pro.code;

import java.util.*;

public class IsValidBST {

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
    //DFS
    public static void main(String[] args) {
        TreeNode rl2 = new TreeNode(2,null,null);
        TreeNode rr2 = new TreeNode(2,null,null);
        TreeNode l1 = new  TreeNode(2,rr2,rl2);
        System.out.println(isValidBST(l1));
    }

    /**
     *  1. 建了一个队列,把根节点入队, 出队后,先记录该 节点(parent),
     *  2. 出队,先后加入left,right,判断left,right是否符合二叉搜索树定义(左<root<右&&左子树全部小于root,右子树全部大于于root),或者
     *  left == null && right == null;
     *  3. 符合,再把队列头节点出列, ----重复2的步骤,在重复3的步骤
     *  4. 当队列为空时, 即遍历完成 ,则显示true
     *
     *  1. 构造中序遍历,遍历顺序 left-root-right,根据遍历顺序判断大小即可
     *  2. 中序遍历,非递归,先通过while找到最左节点,当left == null时候,证明该节点是最左节点
     *  3. 判断该节点的right,是否还存在子树,同时,先 对该左节点进行处理
     * @param root
     * @return
     */

    public static boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        ArrayList<TreeNode> resList = new ArrayList<>();
//        while(!stack.isEmpty()||root!=null){
//            while(root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            TreeNode theLeft = stack.pop();
//            if(stack!=null){
//                //放入带判断数组
//                resList.add(theLeft);
//                root = theLeft.right;
//            }
//        }
        ArrayList<TreeNode> resList = new ArrayList<>();
        List<TreeNode> treeNodes = curTree(root, resList);
        if(treeNodes!=null){
            for(int i=1;i<resList.size();i++){
                if(resList.get(i).val<=resList.get(i-1).val){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<TreeNode> curTree(TreeNode root,ArrayList<TreeNode> list){
        if(root==null){
            return null;
        }
        curTree(root.left,list);
        list.add(root);
        curTree(root.right,list);
        return list;
    }
}
