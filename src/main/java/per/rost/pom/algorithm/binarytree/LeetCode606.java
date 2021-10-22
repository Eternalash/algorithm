package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.Stack;

/**
 * Author:bryan.c
 * Date:2021/8/24
 */
public class LeetCode606 {
    private static final LeetCode606 INSTANCE = new LeetCode606();

    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(INSTANCE.tree2str(root));
        System.out.println(INSTANCE.tree2str2(root));
    }

    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return root.val + "";
        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    public String tree2str2(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder result = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                result.append("(").append(p.val);
                if (p.left != null) {
                    TreeNode tmp = p.left;
                    p.left = null;
                    p = tmp;
                } else {
                    if (p.right != null) {
                        result.append("()");
                    }
                    p = null;
                }
            } else {
                p =stack.peek();
                if (p.right != null) {
                    TreeNode tmp = p.right;
                    p.right = null;
                    p = tmp;
                } else {
                    stack.pop();
                    p = null;
                    result.append(")");
                }
            }
        }
        return result.substring(1, result.toString().length()-1);
    }
}
