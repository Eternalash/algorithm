package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: bryan.c
 * @date: 2021/8/8 下午4:13
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode101 {
    private static final LeetCode101 INSTANCE=new LeetCode101();

    public static void main(String... args){
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(),new TreeNode(4)),new TreeNode(2,new TreeNode(),new TreeNode(4)));
        System.out.println(INSTANCE.isSymmetric(root));
        System.out.println(INSTANCE.isSymmetricBFS(root));
    }

    //DFS
    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return symmetric(root.left,root.right);
    }

    //BFS
    public boolean isSymmetricBFS(TreeNode root){
        if(root==null) return true;
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode source=queue.poll();
            TreeNode target=queue.poll();
            if(source==null && target==null)
                continue;
            if(source==null || target==null)
                return false;
            if(source.val!=target.val)
                return false;
            queue.offer(source.left);
            queue.offer(target.right);

            queue.offer(source.right);
            queue.offer(target.left);
        }
        return true;
    }


    private boolean symmetric(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val && symmetric(p.left,q.right)&&symmetric(p.right,q.left);
    }
}
