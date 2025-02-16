package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">92. 反转链表 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-20
 */
public class 反转链表II {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4, 5);
        System.out.println(ListUtil.toList(head));
        ListNode result = reverseList(head, 2, 4);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 4, 3, 2, 5 }, list.toArray(new Integer[0]));
    }

    /**
     * 借助栈来实现，时间复杂度：O(2N)
     */
    public static ListNode reverseList(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        ListNode cur = head;
        for (int i = 1; i < m - 1; i++) {
            cur = cur.next;
        }
        cur.next = reverseN(cur.next, n - m + 1);
        return head;
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != null && n > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        if (head != null) {
            head.next = cur;
        }
        return pre;
    }

}
