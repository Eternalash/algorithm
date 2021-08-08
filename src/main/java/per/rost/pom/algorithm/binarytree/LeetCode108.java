package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * @author: bryan.c
 * @date: 2021/8/8 下午8:54
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode108 {
    private static final LeetCode108 INSTANCE=new LeetCode108();

    public static void main(String... args){
        int[] nums=new int[]{-10,-2,0,2,5,9};
        System.out.println(INSTANCE.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}
