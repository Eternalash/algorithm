package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * @author: bryan.c
 * @date: 2021/8/8 下午9:19
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode110 {
    private static final LeetCode110 INSTANCE=new LeetCode110();

    public static void main(String... args){

    }

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int depth=1;
        return Math.abs(maxDepth(root.left,depth)-maxDepth(root.right,depth))<=1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root,int depth){
        if (root==null) return depth;
        return Math.max(maxDepth(root.left,depth+1),maxDepth(root.right,depth+1));
    }

    public boolean isBalancedV2(TreeNode root) {
        return depth(root)!=-1;
    }

    private int depth(TreeNode root ) {
        if(root==null) return 0;
        int left=depth(root.left);
        if(left==-1) return -1;
        int right=depth(root.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<2 ? Math.max(left,right)+1:-1;
    }

}
