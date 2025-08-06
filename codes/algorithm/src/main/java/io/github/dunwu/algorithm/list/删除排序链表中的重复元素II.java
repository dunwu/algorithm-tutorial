package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 3, 4, 4, 5);
        System.out.println(ListUtil.toList(head));
        ListNode result = deleteDuplicates2(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 5 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(1, 1, 1, 2, 3);
        System.out.println(ListUtil.toList(head2));
        ListNode result2 = deleteDuplicates2(head2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 2, 3 }, list2.toArray(new Integer[0]));

        ListNode head3 = ListUtil.buildList(1, 2, 2);
        System.out.println(ListUtil.toList(head3));
        ListNode result3 = deleteDuplicates2(head3);
        List<Integer> list3 = ListUtil.toList(result3);
        System.out.println(list3);
        Assertions.assertArrayEquals(new Integer[] { 1 }, list3.toArray(new Integer[0]));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean flag = false;
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode pre = dummy, begin = head, end = head.next;
        while (end != null) {
            if (begin.val == end.val) {
                flag = true;
                end = end.next;
            } else {
                if (flag) {
                    pre.next = end;
                    begin = end;
                    end = end.next;
                    flag = false;
                } else {
                    pre = pre.next;
                    begin = begin.next;
                    end = end.next;
                }
            }
        }
        if (flag) { pre.next = end; }
        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dupList = new ListNode(101);
        ListNode nodupList = new ListNode(101);
        ListNode pDup = dupList, pNoDup = nodupList, p = head;
        while (p != null) {
            if (p.next != null && p.next.val == p.val || p.val == pDup.val) {
                pDup.next = p;
                pDup = pDup.next;
            } else {
                pNoDup.next = p;
                pNoDup = pNoDup.next;
            }

            p = p.next;
            pDup.next = null;
            pNoDup.next = null;
        }
        return nodupList.next;
    }

}
