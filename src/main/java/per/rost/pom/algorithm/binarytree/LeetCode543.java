package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/8/18
 * [1,2,3,4,5,null,7,null,6]
 */
public class LeetCode543 {
    private static final LeetCode543 INSTANCE = new LeetCode543();
    int sum;

    public static void main(String... args) {
        TreeNode root = new TreeNode(0, null, new TreeNode(2236, new TreeNode(1277, new TreeNode(519), null), new TreeNode(2776)));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=dfs(root.left);
        int r=dfs(root.right);
        sum=Math.max(sum,l+r);
        return Math.max(l,r)+1;
    }
}
