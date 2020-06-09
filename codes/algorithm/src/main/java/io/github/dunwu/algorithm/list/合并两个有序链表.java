package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 合并两个有序链表 {

    public static void main(String[] args) {
        ListNode head1 = ListUtil.buildList(1, 2, 4);
        ListNode head2 = ListUtil.buildList(1, 3, 4);
        ListNode result = mergeTwoLists(head1, head2);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4 }, list.toArray(new Integer[0]));
    }

    /**
     * <code>合并两个有序链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">合并两个有序链表</a>
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);

        ListNode node = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 == null) {
            node.next = l2;
        } else {
            node.next = l1;
        }

        return root.next;
    }

}
