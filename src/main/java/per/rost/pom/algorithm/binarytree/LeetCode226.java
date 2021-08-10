package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.Stack;

/**
 * Author:bryan.c
 * Date:2021/8/10
 */
public class LeetCode226 {
    private static final LeetCode226 INSTANCE = new LeetCode226();


    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        System.out.println(INSTANCE.invertTree(root));
        System.out.println(INSTANCE.invertTreeBFS(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        if (root.left==null&&root.right==null)return root;
        TreeNode tmp=new TreeNode(root.val);
        tmp.right=invertTree(root.left);
        tmp.left=invertTree(root.right);
        return tmp;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if(root==null) return null;
        if (root.left==null&&root.right==null)return root;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if (node==null) continue;
            stack.push(node.left);
            stack.push(node.right);
            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
        }
        return root;
    }



}
