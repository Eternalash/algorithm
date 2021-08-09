package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:bryan.c
 * Date:2021/8/9
 */
public class LeetCode111 {
    private static final LeetCode111 INSTANCE = new LeetCode111();

    public static void main(String... args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, null, new TreeNode(8)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(3, null, new TreeNode(20, null, new TreeNode(7,null,new TreeNode(9,null,new TreeNode(21)))));
        System.out.println(INSTANCE.minDepth(root));
        System.out.println(INSTANCE.minDepthBFS(root));

        System.out.println(INSTANCE.minDepth(root2));
        System.out.println(INSTANCE.minDepthBFS(root2));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        int depth = Integer.MAX_VALUE;
        if (root.left != null) depth = Math.min(minDepth(root.left), depth);
        if (root.right != null) depth = Math.min(minDepth(root.right), depth);
        return depth + 1;
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
