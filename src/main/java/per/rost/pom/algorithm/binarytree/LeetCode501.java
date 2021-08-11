package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:bryan.c
 * Date:2021/8/11
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * ！！！！！！！！
 * BST中序遍历可视为有序数组
 * ！！！！！！！！
 */
public class LeetCode501 {
    private static final LeetCode501 INSTANCE = new LeetCode501();

    int count, maxCount;
    TreeNode pre=null;
    List<Integer> answer = new ArrayList<Integer>();

    public static void main(String... args) {
        TreeNode root = new TreeNode(1,new TreeNode(0, new TreeNode(-1), new TreeNode(0,new TreeNode(0),null )), new TreeNode(2, new TreeNode(2),new TreeNode(2)));
        System.out.println(Arrays.toString(INSTANCE.findMode(root)));

    }


    public int[] findMode(TreeNode root) {
        searchBST(root);
        int[] res=new int[answer.size()];
        for (int i=0;i<answer.size();i++){
            res[i] =answer.get(i);
        }
        return res;
    }

    public void searchBST(TreeNode root){
        if (root ==null) return;
        //前序
        searchBST(root.left);
        //中序
        if (pre==null){
            count=1;
        }else if(pre.val== root.val){
            count++;
        }else{
            count=1;
        }
        pre= root;
        if (count==maxCount){
            answer.add(root.val);
        }
        if (count>maxCount){
            maxCount=count;
            answer.clear();
            answer.add(root.val);
        }
        //后序
        searchBST(root.right);
    }
}
