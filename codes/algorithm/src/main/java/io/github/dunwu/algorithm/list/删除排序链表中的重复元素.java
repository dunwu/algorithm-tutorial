package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">83. 删除排序链表中的重复元素</a>
 * @since 2020-06-09
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 1, 2);
        System.out.println(ListUtil.toList(head));
        ListNode result = deleteDuplicates(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, list.toArray(new Integer[0]));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
