package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/8/10
 * 二叉搜索树，左节点小于根节点，根节点小于右节点
 */
public class LeetCode235 {
    private static final LeetCode235 INSTANCE = new LeetCode235();


    public static void main(String... args) {
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4,new TreeNode(3),new TreeNode(5) )),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(INSTANCE.lowestCommonAncestor(root,new TreeNode(2),new TreeNode(8)).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        if (root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}
