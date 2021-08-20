package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

/**
 * Author:bryan.c
 * Date:2021/8/18
 */
public class LeetCode530 {
    private static final LeetCode530 INSTANCE = new LeetCode530();


    public static void main(String... args) {
        TreeNode root = new TreeNode(0, null, new TreeNode(2236, new TreeNode(1277, new TreeNode(519), null), new TreeNode(2776)));
        System.out.println(INSTANCE.getMinimumDifferenceMorris(root));
        System.out.println(INSTANCE.getMinimumDifference(root));
    }

    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public int getMinimumDifferenceMorris(TreeNode root) {
        TreeNode cur = root, mostRight, pre = root;
        int min = Integer.MAX_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 到达两次的节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur; // 第一次到
                    cur = cur.left;
                    System.out.println("2d-1==cur:" + cur.val + "-pre:" + pre.val);
                    continue;
                } else {
                    // 第二次到
                    mostRight.right = null;
                    min = Math.min(min, cur == pre ? Integer.MAX_VALUE : Math.abs(cur.val - pre.val));
                }
            } else { // 到达一次的节点
                min = Math.min(min, cur == pre ? Integer.MAX_VALUE : Math.abs(cur.val - pre.val));
            }
            //等效上面两次相同代码逻辑的合并
//            min=Math.min(min,cur==pre?Integer.MAX_VALUE: Math.abs(cur.val-pre.val));
            pre = cur;
            cur = cur.right;
        }
        return min;
    }
}
