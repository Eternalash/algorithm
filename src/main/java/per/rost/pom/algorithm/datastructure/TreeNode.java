package per.rost.pom.algorithm.datastructure;

/**
 * @author: bryan.c
 * @date: 2021/8/8 上午11:22
 * @package: per.rost.pom.algorithm.datastructure
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
