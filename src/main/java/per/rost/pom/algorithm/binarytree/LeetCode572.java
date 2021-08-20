package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/8/19
 */
public class LeetCode572 {
    private static final LeetCode572 INSTANCE = new LeetCode572();

    public static void main(String... args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
        TreeNode subRoot = new TreeNode(2, new TreeNode(3), new TreeNode(5));
        System.out.println(INSTANCE.isSubtree(root,subRoot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null && subRoot==null) return true;
        if (root==null || subRoot==null) return false;
        return check(root,subRoot)|| isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot){
        if (root==null && subRoot==null) return true;
        if (root==null || subRoot==null || root.val!=subRoot.val) return false;
        return check(root.left,subRoot.left)&& check(root.right,subRoot.right);
    }
}
