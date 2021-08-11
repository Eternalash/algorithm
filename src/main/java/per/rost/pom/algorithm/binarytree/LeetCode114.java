package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/8/11
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 */
public class LeetCode114 {
    private static final LeetCode114 INSTANCE = new LeetCode114();


    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(3),new TreeNode(4) ), new TreeNode(5,new TreeNode(6),new TreeNode(7) ));
        INSTANCE.flatten(root);
        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        if (root ==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=null;
        root.right=left;

        TreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}
