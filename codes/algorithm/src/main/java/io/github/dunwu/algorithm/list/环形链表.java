package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">141. 环形链表</a>
 * @since 2020-06-09
 */
public class 环形链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(3, 2, 0, -4);
        Assertions.assertFalse(hasCycle(head));

        ListNode head2 = ListUtil.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertTrue(hasCycle(head2));

        ListNode head3 = ListUtil.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertTrue(hasCycle(head3));

        ListNode head4 = ListUtil.buildCycleList(1, new int[] { 1 });
        Assertions.assertFalse(hasCycle(head4));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
