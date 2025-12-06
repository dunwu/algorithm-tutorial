package io.github.dunwu.algorithm.linkedlist.reverse;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">25. K 个一组翻转链表</a>
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
            if (head == null || head.next == null) { return head; }
            ListNode p = head;
            for (int i = 0; i < k; i++) {
                if (p == null) { return head; }
                p = p.next;
            }
            ListNode newHead = reverseN(head, k);
            head.next = reverseKGroup(p, k);
            return newHead;
        }

        public ListNode reverseN(ListNode head, int len) {
            if (head == null) { return null; }
            ListNode pre = null, cur = head;
            for (int i = 0; i < len; i++) {
                if (cur == null) { break; }
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            head.next = cur;
            return pre;
        }

    }

}
