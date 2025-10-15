package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-20
 */
public class 反转链表II {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4, 5);
        System.out.println(ListUtil.toList(head));
        ListNode result = reverseBetween(head, 2, 4);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 4, 3, 2, 5 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(3, 5);
        System.out.println(ListUtil.toList(head2));
        ListNode result2 = reverseBetween(head2, 1, 2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 5, 3 }, list2.toArray(new Integer[0]));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        ListNode pre = head;
        for (int i = 1; i < left - 1; i++) {
            pre = pre.next;
        }
        pre.next = reverseN(pre.next, right - left + 1);
        return head;
    }

    static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, next = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
            n--;
        }
        head.next = cur;
        return pre;
    }

}
