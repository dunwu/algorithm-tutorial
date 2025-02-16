package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/lMSNwu/description/">LCR 025. 两数相加II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 两数相加II {

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(ListUtil.buildList(7, 2, 4, 3), ListUtil.buildList(5, 6, 4));
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 7, 8, 0, 7 }, list.toArray());

        ListNode result2 = addTwoNumbers(ListUtil.buildList(2, 4, 3), ListUtil.buildList(5, 6, 4));
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 8, 0, 7 }, list2.toArray());

        ListNode result3 = addTwoNumbers(ListUtil.buildList(0), ListUtil.buildList(0));
        List<Integer> list3 = ListUtil.toList(result3);
        System.out.println(list3);
        Assertions.assertArrayEquals(new Integer[] { 0 }, list3.toArray());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 将两个链表倒置，方便先从低位到高位，逐次相加
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode result = 两数相加.addTwoNumbers(r1, r2);
        return reverse(result);
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
