package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle/">141. 环形链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 环形链表 {

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode head = ListNode.buildList(3, 2, 0, -4);
        Assertions.assertFalse(s.hasCycle(head));

        ListNode head2 = ListNode.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertTrue(s.hasCycle(head2));

        ListNode head3 = ListNode.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertTrue(s.hasCycle(head3));

        ListNode head4 = ListNode.buildCycleList(1, new int[] { 1 });
        Assertions.assertFalse(s.hasCycle(head4));
    }

    static class Solution {

        public boolean hasCycle(ListNode head) {
            // 快慢指针初始化指向 head
            ListNode slow = head, fast = head;
            // 快指针走到末尾时停止
            while (fast != null && fast.next != null) {
                // 慢指针走一步，快指针走两步
                slow = slow.next;
                fast = fast.next.next;
                // 快慢指针相遇，说明含有环
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }

    }

}
