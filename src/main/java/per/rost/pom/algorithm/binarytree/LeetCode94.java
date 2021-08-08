package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: bryan.c
 * @date: 2021/8/8 上午11:20
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode94 {
    private static final LeetCode94 INSTANCE=new LeetCode94();

    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(INSTANCE.inorderTraversal(root));
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
}
