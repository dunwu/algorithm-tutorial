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
        ListNode result = reverseBetween2(head, 2, 4);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 4, 3, 2, 5 }, list.toArray(new Integer[0]));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        // 找到第 m 个节点的前驱
        ListNode pre = head;
        for (int i = 1; i < left - 1; i++) {
            pre = pre.next;
        }
        // 从第 m 个节点开始反转
        pre.next = reverseN(pre.next, right - left + 1);
        return head;
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween2(head.next, left - 1, right - 1);
        return head;
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n--;
        }
        // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
        head.next = cur;
        // 此时的 pre 是反转后的头结点
        return pre;
    }

}
