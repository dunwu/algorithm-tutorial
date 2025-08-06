package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
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
        LinkedList<Integer> list1 = reverse(l1);
        LinkedList<Integer> list2 = reverse(l2);
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            int x = list1.pop();
            int y = list2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            list.push(sum % 10);
        }
        while (!list1.isEmpty()) {
            int x = list1.pop();
            int sum = x + carry;
            carry = sum / 10;
            list.push(sum % 10);
        }
        while (!list2.isEmpty()) {
            int y = list2.pop();
            int sum = y + carry;
            carry = sum / 10;
            list.push(sum % 10);
        }
        if (carry > 0) {
            list.push(carry);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!list.isEmpty()) {
            int x = list.pop();
            p.next = new ListNode(x);
            p = p.next;
        }
        return dummy.next;
    }

    public static LinkedList<Integer> reverse(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.push(head.val);
            head = head.next;
        }
        return list;
    }

}
