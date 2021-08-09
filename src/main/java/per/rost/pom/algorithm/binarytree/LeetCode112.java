package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:bryan.c
 * Date:2021/8/9
 */
public class LeetCode112 {
    private static final LeetCode112 INSTANCE = new LeetCode112();


    public static void main(String... args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11,new TreeNode(7),new TreeNode(2) ),null), new TreeNode(8, new TreeNode(13), new TreeNode(4,null,new TreeNode(7))));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(INSTANCE.hasPathSum(root,22));
        System.out.println(INSTANCE.hasPathSum(root2,5));


        System.out.println(INSTANCE.hasPathSumBFS(root,22));
        System.out.println(INSTANCE.hasPathSumBFS(root2,5));


    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> valQ=new LinkedList<>();
        queue.offer(root);
        valQ.offer(targetSum);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                int newSum=valQ.poll();
                if(cur == null) continue;
                if(cur.left == null && cur.right == null) {
                    if( newSum == cur.val){
                        return true;
                    }
                    continue;
                }

                queue.offer(cur.left);
                queue.offer(cur.right);
                valQ.offer(newSum-cur.val);
                valQ.offer(newSum-cur.val);
            }
        }
        return false;
    }
}
