package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: bryan.c
 * @date: 2021/8/8 上午11:20
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode94 {
    private static final LeetCode94 INSTANCE=new LeetCode94();

    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        System.out.println(INSTANCE.inorderTraversal(root));
        System.out.println(INSTANCE.inorderTraversalBFS(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    public void traversal(TreeNode root,List<Integer> res){
        if (root==null) return;
        traversal(root.left,res);
        res.add(root.val);
        traversal(root.right,res);
    }

    public List<Integer> inorderTraversalBFS(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return res;
    }
}
