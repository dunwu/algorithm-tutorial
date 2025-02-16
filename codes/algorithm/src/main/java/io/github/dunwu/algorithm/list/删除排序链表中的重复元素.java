package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">83. 删除排序链表中的重复元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
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

        ListNode head2 = ListUtil.buildList(1, 1, 2, 3, 3);
        System.out.println(ListUtil.toList(head2));
        ListNode result2 = deleteDuplicates(head2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, list2.toArray(new Integer[0]));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }

}
