package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第 N 个结点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
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

        ListNode head3 = ListUtil.buildList(1, 2);
        ListNode result3 = removeNthFromEnd(head3, 1);
        List<Integer> list3 = ListUtil.toList(result3);
        System.out.println(list3);
        Assertions.assertArrayEquals(new Integer[] { 1 }, list3.toArray(new Integer[0]));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

}
