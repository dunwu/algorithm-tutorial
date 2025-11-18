package io.github.dunwu.algorithm.linkedlist.reverse;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-20
 */
public class 反转链表2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode result = s.reverseBetween(ListNode.buildList(1, 2, 3, 4, 5), 2, 4);
        Assertions.assertEquals(ListNode.buildList(1, 4, 3, 2, 5), result);
        ListNode result2 = s.reverseBetween(ListNode.buildList(3, 5), 1, 2);
        Assertions.assertEquals(ListNode.buildList(5, 3), result2);
    }

    static class Solution {

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseN(head, right);
            }

            // 找到第 left 个节点的前驱
            ListNode pre = head;
            for (int i = 1; i < left - 1; i++) {
                pre = pre.next;
            }

            // 从第 left 个节点开始反转
            int len = right - left + 1;
            pre.next = reverseN(pre.next, len);
            return pre;
        }

        private ListNode reverseN(ListNode head, int len) {
            if (head == null || head.next == null) { return head; }
            ListNode pre = null, cur = head, next = cur.next;
            while (len-- > 0) {
                cur.next = pre;
                pre = cur;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
            // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
            head.next = cur;
            // 此时的 pre 是反转后的头结点
            return pre;
        }

    }

}
