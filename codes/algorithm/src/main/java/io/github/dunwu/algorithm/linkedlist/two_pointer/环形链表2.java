package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">142. 环形链表 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-08
 */
public class 环形链表2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode input = ListNode.buildList(3, 2, 0, -4);
        Assertions.assertNull(s.detectCycle(input));

        ListNode input2 = ListNode.buildList(1);
        Assertions.assertNull(s.detectCycle(input2));

        ListNode input3 = ListNode.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertEquals(2, s.detectCycle(input3).val);

        ListNode input4 = ListNode.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertEquals(1, s.detectCycle(input4).val);
    }

    static class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode fast, slow;
            fast = slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }

            // fast 遇到空指针说明没有环
            if (fast == null || fast.next == null) {
                return null;
            }

            // 重新指向头结点
            slow = head;

            // 快慢指针同步前进，相交点就是环起点
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

    }

}
