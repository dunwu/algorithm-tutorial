package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并K个排序链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 合并K个排序链表 {

    public static void main(String[] args) {
        ListNode head1 = ListUtil.buildList(1, 4, 5);
        ListNode head2 = ListUtil.buildList(1, 3, 4);
        ListNode head3 = ListUtil.buildList(2, 6);
        ListNode[] array = new ListNode[] { head1, head2, head3 };
        ListNode result = mergeKLists2(array);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4, 5, 6 }, list.toArray(new Integer[0]));

        ListNode[] array2 = new ListNode[] {};
        ListNode result2 = mergeKLists2(array2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] {}, list2.toArray(new Integer[0]));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode root = new ListNode(-1);
        ListNode resultHead = root;
        while (true) {
            Integer minIndex = null;
            Integer minVal = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (minVal == null || lists[i].val < minVal) {
                    minIndex = i;
                    minVal = lists[i].val;
                }
            }

            if (minIndex != null) {
                resultHead.next = new ListNode(lists[minIndex].val);
                resultHead = resultHead.next;
                lists[minIndex] = lists[minIndex].next;
            } else {
                break;
            }
        }

        return root.next;
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
