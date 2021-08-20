package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/8/19
 */
public class LeetCode563 {
    private static final LeetCode563 INSTANCE = new LeetCode563();
    int sum;

    public static void main(String... args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
        System.out.println(INSTANCE.findTilt(root));
    }

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root){
        if (root==null) return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        sum+=Math.abs(left-right);
        return left+right+root.val;
    }

}
