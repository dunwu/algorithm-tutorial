package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">相交链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 相交链表 {

    public static void main(String[] args) {
        ListNode listA = ListUtil.buildList(4, 1, 8, 4, 5);
        ListNode listB = ListUtil.buildList(5, 6, 1, 8, 4, 5);
        buildMetPot(listA, listB, 2, 3);
        ListNode result = getIntersectionNode(listA, listB);
        Assertions.assertEquals(8, result.val);

        ListNode listA2 = ListUtil.buildList(1, 9, 1, 2, 4);
        ListNode listB2 = ListUtil.buildList(3, 2, 4);
        buildMetPot(listA2, listB2, 3, 1);
        ListNode result2 = getIntersectionNode(listA2, listB2);
        Assertions.assertEquals(2, result2.val);
    }

    public static void buildMetPot(ListNode listA, ListNode listB, int skipA, int skipB) {
        ListNode pA = listA;
        for (int i = 0; i < skipA; i++) {
            pA = pA.next;
        }
        ListNode pB = listB;
        for (int i = 0; i < skipB - 1; i++) {
            pB = pB.next;
        }
        pB.next = pA;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
