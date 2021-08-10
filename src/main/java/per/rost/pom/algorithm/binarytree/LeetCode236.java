package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;


/**
 * Author:bryan.c
 * Date:2021/8/10
 */
public class LeetCode236 {
    private static final LeetCode236 INSTANCE = new LeetCode236();


    public static void main(String... args) {
        TreeNode p = new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode q = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode root = new TreeNode(6, p, q);
        System.out.println(INSTANCE.lowestCommonAncestor(root, p, q).val);
    }

    //3,5,1,6,2,0,8,null,null,7,4
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode inLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode inRight = lowestCommonAncestor(root.right, p, q);
        if (inLeft != null && inRight != null) return root;
        if (inLeft == null) return inRight;
        return inLeft;
    }
}
