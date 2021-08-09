package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.*;

/**
 * Author:bryan.c
 * Date:2021/8/9
 */
public class LeetCode144 {
    private static final LeetCode144 INSTANCE = new LeetCode144();


    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(3),new TreeNode(4) ), new TreeNode(5,new TreeNode(6),new TreeNode(7) ));

        System.out.println(INSTANCE.preorderTraversal(root));
        System.out.println(INSTANCE.preorderTraversalBFS(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        return helper(root,res);
    }

    private List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root==null) return res;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
        return res;
    }

    public List<Integer> preorderTraversalBFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
