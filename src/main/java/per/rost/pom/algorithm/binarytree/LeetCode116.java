package per.rost.pom.algorithm.binarytree;

import per.rost.pom.algorithm.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:bryan.c
 * Date:2021/8/11
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 */
public class LeetCode116 {
    private static final LeetCode116 INSTANCE = new LeetCode116();


    public static void main(String... args) {
        Node root = new Node(1, new Node(2, new Node(3), new Node(4)), new Node(5, new Node(6), new Node(7)));

        System.out.println(INSTANCE.connectBFS(root));
    }

    public Node connect(Node root) {
        if (root==null) return null;

        connect(root.left,root.right);
        return root;
    }

    public void connect(Node node1,Node node2){
        if(node1==null || node2==null) return;
        node1.next=node2;
        connect(node1.left,node1.right);
        connect(node2.left,node2.right);
        connect(node1.right,node2.left);
    }

    public Node connectBFS(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty() && root != null) {
            int size = que.size();
            Node pre = null;
            while (size-- > 0) {
                Node cur = que.poll();
                if (pre != null) pre.next = cur;
                pre = cur;
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
