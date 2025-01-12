package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 合并K个排序链表 {

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

    /**
     * <code>23. 合并K个排序链表</code> 算法实现
     * <p>
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <pre>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并K个排序链表</a>
     */
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
        List<ListNode> nodeList = new ArrayList<>();
        for (ListNode head : lists) {
            while (head != null) {
                nodeList.add(head);
                head = head.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode p = result;
        Collections.sort(nodeList, (a, b) -> a.val - b.val);
        for (ListNode node : nodeList) {
            p.next = node;
            p = p.next;
        }
        return result.next;
    }

}
