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
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode x = l1, y = l2, p = dummy;
        while (x != null && y != null) {
            int sum = x.val + y.val + carry;
            carry = sum / 10;
            p.next = sum >= 0 ? new ListNode(sum % 10) : new ListNode(sum);
            p = p.next;
            x = x.next;
            y = y.next;
        }
        while (x != null) {
            int sum = x.val + carry;
            carry = sum / 10;
            p.next = sum >= 0 ? new ListNode(sum % 10) : new ListNode(sum);
            p = p.next;
            x = x.next;
        }
        while (y != null) {
            int sum = y.val + carry;
            carry = sum / 10;
            p.next = sum >= 0 ? new ListNode(sum % 10) : new ListNode(sum);
            p = p.next;
            y = y.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
