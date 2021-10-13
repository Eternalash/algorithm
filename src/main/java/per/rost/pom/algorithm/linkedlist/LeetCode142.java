package per.rost.pom.algorithm.linkedlist;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * Author:bryan.c
 * Date:2021/9/27
 * 输出的是入环点
 *
 *                (b)--(相遇点)
 *                /    \
 * <start>--(a)--/      \
 *               \      /
 *                \    /
 *                  --(c)
 * 快指针走过的路径 a+n(b+c)+b
 * 满指针走过的路径 a+b
 * 所以 a+n(b+c)+b=2(a+b)
 * 整理得 a=c+(n−1)(b+c)
 * 得出：从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LeetCode142 {
    private static final LeetCode142 INSTANCE=new LeetCode142();

    public static void main(String... args){
        ListNode node=new ListNode(7);
        ListNode node1=new ListNode(6);
        node1.next=node;
        ListNode cyclePoint=new ListNode(4,new ListNode(5,node1));
        node.next=cyclePoint;
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,cyclePoint)));
        System.out.println(INSTANCE.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
