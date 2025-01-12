package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">删除链表的倒数第 N 个结点</a>
 * @since 2020-06-09
 */
public class 删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        ListNode head1 = ListUtil.buildList(1, 2, 3, 4, 5);
        ListNode result = removeNthFromEnd(head1, 2);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 5 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(1);
        ListNode result2 = removeNthFromEnd(head2, 1);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] {}, list2.toArray(new Integer[0]));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (n < 1) {
            return head;
        }

        ListNode fast = head;
        for (int i = 0; i < n + 1 && fast != null; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
