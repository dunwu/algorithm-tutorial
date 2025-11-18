package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 合并两个有序链表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h1 = ListNode.buildList(1, 2, 4);
        ListNode h2 = ListNode.buildList(1, 3, 4);
        ListNode result = s.mergeTwoLists(h1, h2);
        Assertions.assertEquals(ListNode.buildList(1, 1, 2, 3, 4, 4), result);
    }

    static class Solution {

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
