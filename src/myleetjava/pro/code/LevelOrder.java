package myleetjava.pro.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LevelOrder {

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
     * 层序遍历,创建一个queue,先逐层 left-->right 进队,
     * 创建一个计数器,用于统计每层的节点数,循环出队入队
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> floor = new ArrayList<>();
            //每次循环回来queue里面的大小就是当前 层节点数
            int count = queue.size();
            //循环出队
            for(int i=0;i<count;i++){
                //头元素出队
                TreeNode thisNode = queue.remove();
                if(thisNode.left!=null){
                    queue.add(thisNode.left);
                }
                if(thisNode.right!=null){
                    queue.add(thisNode.right);
                }
                //加入每层的list
                floor.add(thisNode.val);
            }
            res.add(floor);
        }
        return res;
    }
}
