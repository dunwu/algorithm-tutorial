package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/partition-list/">86. 分隔链表</a>
 * @since 2020-07-06
 */
public class 分隔链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 4, 3, 2, 5, 2);
        ListNode result = partition(head, 3);
        List<Integer> list = ListUtil.toList(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 2, 4, 3, 5 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(2, 1);
        ListNode result2 = partition(head2, 2);
        List<Integer> list2 = ListUtil.toList(result2);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, list2.toArray(new Integer[0]));

        ListNode head3 = ListUtil.buildList(3, 1, 2);
        ListNode result3 = partition(head3, 3);
        List<Integer> list3 = ListUtil.toList(result3);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, list3.toArray(new Integer[0]));
    }

    public static ListNode partition(ListNode head, int x) {
        return null;
    }

}
