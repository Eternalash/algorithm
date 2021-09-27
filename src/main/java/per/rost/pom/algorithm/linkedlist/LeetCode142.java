package per.rost.pom.algorithm.linkedlist;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * Author:bryan.c
 * Date:2021/9/27
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LeetCode142 {
    private static final LeetCode142 INSTANCE=new LeetCode142();

    public static void main(String... args){
        ListNode node=new ListNode(7);
        ListNode node1=new ListNode(6);
        node1.next=node;
        ListNode start=new ListNode(4,new ListNode(5,node1));
        node.next=start;
        System.out.println(INSTANCE.detectCycle(new ListNode(1,new ListNode(2,new ListNode(3,start)))));
    }

    public ListNode detectCycle(ListNode head) {

    }
}
