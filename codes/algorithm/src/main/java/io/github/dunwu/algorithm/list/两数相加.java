package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/submissions/594544269/">2. 两数相加</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(ListUtil.buildList(2, 4, 3), ListUtil.buildList(5, 6, 4));
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 7, 0, 8 }, list.toArray());

        ListNode result2 = addTwoNumbers(ListUtil.buildList(0), ListUtil.buildList(0));
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 0 }, list2.toArray());

        ListNode result3 = addTwoNumbers(ListUtil.buildList(9, 9, 9, 9, 9, 9, 9), ListUtil.buildList(9, 9, 9, 9));
        List<Integer> list3 = ListUtil.toList(result3);
        System.out.println(list3);
        Assertions.assertArrayEquals(new Integer[] { 8, 9, 9, 9, 0, 0, 0, 1 }, list3.toArray());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 如果任意一个表示数的链表为空，直接返回另一个链表
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 初始化
        int carry = 0;
        ListNode x = l1;
        ListNode y = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 同时遍历两个操作数链表，任意操作数链表的当前位数所对应元素不为 null 则累加
        while (x != null || y != null) {
            int value = carry;

            if (x != null) {
                value += x.val;
                x = x.next;
            }

            if (y != null) {
                value += y.val;
                y = y.next;
            }

            carry = value / 10;
            p.next = new ListNode(value % 10);
            p = p.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
