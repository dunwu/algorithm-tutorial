package io.github.dunwu.algorithm.linkedlist.reverse;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并 K 个升序链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class K个一组翻转链表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode output = s.reverseKGroup(ListNode.buildList(1, 2, 3, 4, 5), 2);
        Assertions.assertEquals(ListNode.buildList(2, 1, 4, 3, 5), output);
        ListNode output2 = s.reverseKGroup(ListNode.buildList(1, 2, 3, 4, 5), 3);
        Assertions.assertEquals(ListNode.buildList(3, 2, 1, 4, 5), output2);
    }

    static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            // 区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转了
                if (b == null) return head;
                b = b.next;
            }
            // 反转前 k 个元素
            ListNode newHead = reverseN(a, k);
            // 此时 b 指向下一组待反转的头结点
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);

            return newHead;
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
