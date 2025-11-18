package io.github.dunwu.algorithm.linkedlist.reverse;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206. 反转链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 反转链表 {

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode result = s.reverseList(ListNode.buildList(1, 2, 3, 4));
        Assertions.assertEquals(ListNode.buildList(4, 3, 2, 1), result);

        ListNode result2 = s.reverseList(ListNode.buildList(1, 2));
        Assertions.assertEquals(ListNode.buildList(2, 1), result2);

        ListNode result3 = s.reverseList(ListNode.buildList());
        Assertions.assertEquals(ListNode.buildList(), result3);
    }

    static class Solution {

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) { return head; }
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }

}
