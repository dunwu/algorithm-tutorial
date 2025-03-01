package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">142. 环形链表 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-08
 */
public class 环形链表II {

    public static void main(String[] args) {
        // ListNode head = ListUtil.buildList(3, 2, 0, -4);
        // Assertions.assertEquals(null, detectCycle(head));

        ListNode head2 = ListUtil.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertEquals(2, detectCycle2(head2).val);

        ListNode head3 = ListUtil.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertEquals(1, detectCycle2(head3).val);

        ListNode head4 = ListUtil.buildCycleList(1, new int[] { 1 });
        Assertions.assertEquals(null, detectCycle2(head4));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
