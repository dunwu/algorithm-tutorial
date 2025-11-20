package io.github.dunwu.algorithm.linkedlist.reverse;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/rotate-list/">61. 旋转链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-11-20
 */
public class 旋转链表 {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode input = ListNode.buildList(1, 2, 3, 4, 5);
        ListNode output = s.rotateRight(input, 2);
        Assertions.assertEquals(ListNode.buildList(4, 5, 1, 2, 3), output);

        ListNode input2 = ListNode.buildList(0, 1, 2);
        ListNode output2 = s.rotateRight(input2, 4);
        Assertions.assertEquals(ListNode.buildList(2, 0, 1), output2);

        ListNode input3 = ListNode.buildList(1, 2);
        ListNode output3 = s.rotateRight(input3, 1);
        Assertions.assertEquals(ListNode.buildList(2, 1), output3);

        ListNode input4 = ListNode.buildList(1, 2);
        ListNode output4 = s.rotateRight(input4, 3);
        Assertions.assertEquals(ListNode.buildList(2, 1), output4);
    }

    static class Solution {

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode newLast = lastFromEnd(head, k + 1);
            ListNode last = newLast;
            while (last.next != null) {
                last = last.next;
            }

            last.next = head;
            dummy.next = newLast.next;
            newLast.next = null;

            return dummy.next;
        }

        public ListNode lastFromEnd(ListNode head, int k) {

            if (head == null || head.next == null) {
                return null;
            }

            int i = 0;
            ListNode slow = head, fast = head;
            while (i < k) {
                i++;
                if (fast == null) {
                    fast = head;
                }
                fast = fast.next;
            }

            // fast 先走 k 步后，slow 从 head 开始出发，当 fast 到底，slow 正好是倒数第 k 个节点
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

}
