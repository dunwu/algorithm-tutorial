package io.github.dunwu.algorithm.list;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">相交链表</a>
 * @since 2020-06-09
 */
public class 相交链表 {

    public static ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
