package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Author:bryan.c
 * Date:2021/8/9
 */
public class LeetCode145 {
    private static final LeetCode145 INSTANCE = new LeetCode145();


    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7)));

        System.out.println(INSTANCE.postorderTraversal(root));
        System.out.println(INSTANCE.postorderTraversalBFS(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return helper(root, res);
    }

    private List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root == null) return res;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
        return res;
    }

    public List<Integer> postorderTraversalBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
