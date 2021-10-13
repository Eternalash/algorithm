package per.rost.pom.algorithm.linkedlist;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * Author:bryan.c
 * Date:2021/9/27
 * 判断是否存在环
 */
public class LeetCode141 {
    private static final LeetCode141 INSTANCE=new LeetCode141();

    public static void main(String... args){
        ListNode node=new ListNode(7);
        ListNode node1=new ListNode(6);
        node1.next=node;
        ListNode cyclePoint=new ListNode(4,new ListNode(5,node1));
        node.next=cyclePoint;
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,cyclePoint)));
        System.out.println(INSTANCE.hasCycle(head));
    }

    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
