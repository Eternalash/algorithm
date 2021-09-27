package per.rost.pom.algorithm.linkedlist;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * Author:bryan.c
 * Date:2021/9/27
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class LeetCode160 {
    private static final LeetCode160 INSTANCE=new LeetCode160();

    public static void main(String... args){
        ListNode comm=new ListNode(4,new ListNode(8));
        ListNode headA=new ListNode(2,new ListNode(6,new ListNode(4)));
        ListNode headB=new ListNode(1,new ListNode(5));
        System.out.println(INSTANCE.getIntersectionNode(headA,headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA=headA,pB=headB;
        while (pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
}
