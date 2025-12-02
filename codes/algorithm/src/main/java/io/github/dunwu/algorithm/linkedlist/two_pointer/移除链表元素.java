package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">203. 移除链表元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 移除链表元素 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(ListNode.buildList(1, 2, 3, 4, 5),
            s.removeElements(ListNode.buildList(1, 2, 6, 3, 4, 5, 6), 6));
        Assertions.assertEquals(ListNode.buildList(), s.removeElements(ListNode.buildList(), 1));
        Assertions.assertEquals(ListNode.buildList(), s.removeElements(ListNode.buildList(7, 7, 7, 7, 7), 7));
    }

    static class Solution {

        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            ListNode p = head, q = dummy;
            while (p != null) {
                if (p.val != val) {
                    q.next = p;
                    q = q.next;
                }
                p = p.next;
            }
            q.next = null;
            return dummy.next;
        }

    }

}
