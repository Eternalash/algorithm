package per.rost.pom.algorithm.medium;

import per.rost.pom.algorithm.datastructure.ListNode;

/**
 * Author:bryan.c
 * Date:2021/9/8
 */
public class LeetCode2 {
    private static final LeetCode2 INSTANCE=new LeetCode2();

    public static void main(String... args) {
        System.out.println(INSTANCE.addTwoNumbers(new ListNode(2,new ListNode(4,new ListNode(3))),new ListNode(5,new ListNode(6,new ListNode(4)))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,tail=null;
        int sum,carry=0;
        while (l1!=null || l2!=null){
            int l1v=l1==null?0:l1.val;
            int l2v=l2==null?0:l2.val;
            sum=l1v+l2v+carry;
            carry=sum/10;
            sum=sum%10;
            if (head==null){
                head=tail=new ListNode(sum);
            }else {
                tail.next=new ListNode(sum);
                tail=tail.next;
            }
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (carry>0){
            tail.next=new ListNode(carry);
        }
        return head;
    }
}
