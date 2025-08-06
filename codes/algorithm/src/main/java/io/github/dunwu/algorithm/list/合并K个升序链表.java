package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并 K 个升序链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 合并K个升序链表 {

    public static void main(String[] args) {
        ListNode head1 = ListUtil.buildList(1, 4, 5);
        ListNode head2 = ListUtil.buildList(1, 3, 4);
        ListNode head3 = ListUtil.buildList(2, 6);
        ListNode[] array = new ListNode[] { head1, head2, head3 };
        ListNode result = mergeKLists(array);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4, 5, 6 }, list.toArray(new Integer[0]));

        ListNode[] array2 = new ListNode[] {};
        ListNode result2 = mergeKLists(array2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] {}, list2.toArray(new Integer[0]));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = 合并两个有序链表.mergeTwoLists(result, lists[i]);
        }
        return result;
    }

}
