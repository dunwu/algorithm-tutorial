package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">相交链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 相交链表 {

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode listA = ListNode.buildList(4, 1, 8, 4, 5);
        ListNode listB = ListNode.buildList(5, 6, 1, 8, 4, 5);
        ListNode.buildMetPot(listA, listB, 2, 3);
        ListNode result = s.getIntersectionNode(listA, listB);
        Assertions.assertEquals(8, result.val);

        ListNode listA2 = ListNode.buildList(1, 9, 1, 2, 4);
        ListNode listB2 = ListNode.buildList(3, 2, 4);
        ListNode.buildMetPot(listA2, listB2, 3, 1);
        ListNode result2 = s.getIntersectionNode(listA2, listB2);
        Assertions.assertEquals(2, result2.val);

        ListNode listA3 = ListNode.buildList(2, 6, 4);
        ListNode listB3 = ListNode.buildList(1, 5);
        ListNode result3 = s.getIntersectionNode(listA3, listB3);
        Assertions.assertNull(result3);
    }

    static class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // pA 指向 A 链表头结点，pB 指向 B 链表头结点
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                // pA 走一步，如果走到 A 链表末尾，转到 B 链表
                if (pA == null) {
                    pA = headB;
                } else {
                    pA = pA.next;
                }
                // pB 走一步，如果走到 B 链表末尾，转到 A 链表
                if (pB == null) {
                    pB = headA;
                } else {
                    pB = pB.next;
                }
            }
            return pA;
        }

    }

}
