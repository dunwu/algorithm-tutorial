package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并 K 个升序链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 合并K个升序链表 {

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode head1 = ListNode.buildList(1, 4, 5);
        ListNode head2 = ListNode.buildList(1, 3, 4);
        ListNode head3 = ListNode.buildList(2, 6);
        ListNode result = s.mergeKLists(new ListNode[] { head1, head2, head3 });
        Assertions.assertEquals(ListNode.buildList(1, 1, 2, 3, 4, 4, 5, 6), result);

        ListNode[] array2 = new ListNode[] {};
        ListNode result2 = s.mergeKLists(array2);
        Assertions.assertEquals(ListNode.buildList(), result2);
    }

    static class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            ListNode l1 = lists[0];
            for (int i = 1; i < lists.length; i++) {
                ListNode l2 = lists[i];
                l1 = mergeTwoLists(l1, l2);
            }
            return l1;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 虚拟头结点
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = l1, p2 = l2;

            while (p1 != null && p2 != null) {
                // 比较 p1 和 p2 两个指针
                // 将值较小的的节点接到 p 指针
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                // p 指针不断前进
                p = p.next;
            }

            if (p1 != null) { p.next = p1; }
            if (p2 != null) { p.next = p2; }

            return dummy.next;
        }

    }

}
