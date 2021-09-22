package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: bryan.c
 * @date: 2021/8/8 上午11:56
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode100 {
    private static final LeetCode100 INSTANCE=new LeetCode100();

    public static void main(String... args){
        TreeNode p=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(INSTANCE.isSameTree(p,q));
        System.out.println(INSTANCE.isSameTreeBFS(p,q));
    }

    //DFS
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
    }

    //BFS
    public boolean isSameTreeBFS(TreeNode p,TreeNode q){
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
