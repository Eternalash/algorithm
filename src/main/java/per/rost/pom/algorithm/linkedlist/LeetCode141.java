package per.rost.pom.algorithm.linkedlist;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * Author:bryan.c
 * Date:2021/9/27
 */
public class LeetCode141 {

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
