package per.rost.pom.algorithm.datastructure;

/**
 * @author: bryan.c
 * @date: 2021/9/7 下午8:47
 * @package: per.rost.pom.algorithm.datastructure
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
