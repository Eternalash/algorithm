package per.rost.pom.algorithm.medium;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * @author: bryan.c
 * @date: 2021/9/7 下午8:44
 * @package: per.rost.pom.algorithm.medium
 * 两数相加
 */
public class LeetCode2 {
    private static final LeetCode2 INSTANCE = new LeetCode2();

    public static void main(String... args){
        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(4)));
        System.out.println(INSTANCE.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
