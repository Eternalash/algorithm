package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.Stack;

/**
 * Author:bryan.c
 * Date:2021/8/11
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class LeetCode404 {
    private static final LeetCode404 INSTANCE = new LeetCode404();


    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        System.out.println(INSTANCE.sumOfLeftLeaves(root));
        System.out.println(INSTANCE.sumOfLeftLeavesV2(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+((root.left!=null&&root.left.left==null&&root.left.right==null)?root.left.val:0);
    }

    public int sumOfLeftLeavesV2(TreeNode root) {
        if (root==null) return 0;
        int sum=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if (node==null) continue;
            if (node.left!=null && node.left.left==null && node.left.right==null){
                sum+=node.left.val;
            }
            stack.push(node.left);
            stack.push(node.right);
        }
        return sum;
    }
}
