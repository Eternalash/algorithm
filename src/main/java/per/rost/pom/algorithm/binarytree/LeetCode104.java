package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: bryan.c
 * @date: 2021/8/8 下午4:52
 * @package: per.rost.pom.algorithm.binarytree
 */
public class LeetCode104 {
    private static final LeetCode104 INSTANCE=new LeetCode104();

    public static void main(String... args){
        TreeNode root=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(INSTANCE.maxDepth(root));
    }

    public int maxDepth(TreeNode root){
        return traversal(root,0);
    }

    public int traversal(TreeNode root,int depth){
        if(root ==null) return depth;
        return Math.max(traversal(root.left,depth+1),traversal(root.right,depth+1));
    }

    public int maxDepthBFS(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }

}
