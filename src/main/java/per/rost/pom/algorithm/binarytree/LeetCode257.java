package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:bryan.c
 * Date:2021/8/11
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class LeetCode257 {
    private static final LeetCode257 INSTANCE = new LeetCode257();


    public static void main(String... args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        System.out.println(INSTANCE.binaryTreePaths(root));
        System.out.println(INSTANCE.binaryTreePathsBFS(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        findPath(root, new StringBuilder(""), res);
        return res;
    }

    private void findPath(TreeNode node, StringBuilder curPath, List<String> res) {
        if (node == null) return;
        curPath.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(curPath.toString());
            return;
        }
        curPath.append("->");
        findPath(node.left, new StringBuilder(curPath), res);
        findPath(node.right, new StringBuilder(curPath), res);
    }

    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> res = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        Stack<String> pathStack=new Stack<>();
        pathStack.push(String.valueOf(root.val));
        while (!stack.isEmpty()){
            String path=pathStack.pop();
            TreeNode cur=stack.pop();

            if(cur.left==null&&cur.right==null){
                res.add(path);
            }
            if(cur.right!=null){
                stack.push(cur.right);
                pathStack.push(path+"->"+cur.right.val);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                pathStack.push(path+"->"+cur.left.val);
            }
        }
        return res;
    }
}
