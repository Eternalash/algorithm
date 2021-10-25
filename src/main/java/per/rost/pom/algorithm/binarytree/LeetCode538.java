package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/10/25
 */
public class LeetCode538 {
    private static final LeetCode538 INSTANCE = new LeetCode538();

    int sum = 0;


    public static void main(String... args) {
        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2,null,new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7,null,new TreeNode(8))));
        System.out.println(INSTANCE.convertBST(root));
    }

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //反序中序遍历8->7->6->...->0
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
