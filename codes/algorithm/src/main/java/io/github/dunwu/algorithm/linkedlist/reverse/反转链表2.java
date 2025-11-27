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

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == 1) {
                return reverseN(head, n);
            }
            // 找到第 m 个节点的前驱
            ListNode pre = head;
            for (int i = 1; i < m - 1; i++) {
                pre = pre.next;
            }
            // 从第 m 个节点开始反转
            pre.next = reverseN(pre.next, n - m + 1);
            return head;
        }

        ListNode reverseN(ListNode head, int n) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre, cur, nxt;
            pre = null;
            cur = head;
            nxt = head.next;
            while (n > 0) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
                n--;
            }
            // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
            head.next = cur;

            // 此时的 pre 是反转后的头结点
            return pre;
        }

    }

}
