package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list">876. 链表的中间结点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 链表的中间结点 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode input = ListNode.buildList(1, 2, 3, 4, 5);
        Assertions.assertEquals(ListNode.buildList(3, 4, 5), s.middleNode(input));
        ListNode input2 = ListNode.buildList(1, 2, 3, 4, 5, 6);
        Assertions.assertEquals(ListNode.buildList(4, 5, 6), s.middleNode(input2));
    }

    static class Solution {

        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

    }

}
