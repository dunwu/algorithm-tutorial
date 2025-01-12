package io.github.dunwu.algorithm.list;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">相交链表</a>
 * @since 2020-06-09
 */
public class 相交链表 {

    /**
     * 时间复杂度：O(m * n)
     */
    public static ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        ListNode a = headA;
        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) {
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(final ListNode headA, final ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

}
