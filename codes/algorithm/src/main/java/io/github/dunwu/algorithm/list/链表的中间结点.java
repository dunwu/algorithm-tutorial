package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list">876. 链表的中间结点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 链表的中间结点 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4, 5);
        System.out.println(ListUtil.toList(head));
        ListNode result = middleNode(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 3, 4, 5 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(1, 2, 3, 4, 5, 6);
        System.out.println(ListUtil.toList(head2));
        ListNode result2 = middleNode(head2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 4, 5, 6 }, list2.toArray(new Integer[0]));
    }

    public static ListNode middleNode(ListNode head) {
        // 利用快慢指针，慢指针每次偏移一个节点，快指针每次偏移两个节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
